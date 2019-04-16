package com.mercadopago.basedois;

import net.sf.jsefa.Serializer;
import net.sf.jsefa.common.lowlevel.LowLevelSerializer;
import net.sf.jsefa.flr.FlrIOFactory;
import net.sf.jsefa.flr.config.FlrConfiguration;
import org.beanio.spring.BeanIOFlatFileItemReader;
import org.beanio.spring.BeanIOFlatFileItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import sun.tools.java.ClassPath;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    ApplicationContext context;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    Resource outputResource = new FileSystemResource("output/outputData.txt");

    @Bean
    public FlatFileItemReader<SettlementDTO> reader(){
        return new FlatFileItemReaderBuilder<SettlementDTO>()
                .name("personItemReader")
                .resource(new ClassPathResource("settlement-report-148956841554440418568.csv"))
                .delimited()
                .names(new String[]{
                        "EXTERNAL_REFERENCE",
                        "SOURCE_ID",
                        "USER_ID",
                        "PAYMENT_METHOD_TYPE",
                        "PAYMENT_METHOD",
                        "SITE",
                        "TRANSACTION_TYPE",
                        "TRANSACTION_AMOUNT",
                        "TRANSACTION_CURRENCY",
                        "TRANSACTION_DATE",
                        "FEE_AMOUNT",
                        "SETTLEMENT_NET_AMOUNT",
                        "SETTLEMENT_CURRENCY",
                        "SETTLEMENT_DATE",
                        "REAL_AMOUNT",
                        "COUPON_AMOUNT",
                        "METADATA"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<SettlementDTO>(){{
                    setTargetType(SettlementDTO.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public SettlementProcessor processor(){
        return new SettlementProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<SettlementDTO> writer(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<SettlementDTO>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO settlement (externalRef, transactionAmount) VALUES (:externalReference, :transactionAmount)")
                .dataSource(dataSource)
                .build();
    }

    private LineAggregator<SettlementDTO> createSettlementAggregator(){
        DelimitedLineAggregator<SettlementDTO> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(";");

        FieldExtractor<SettlementDTO> fieldExtractor = createSettlenmentFieldExtractor();
        lineAggregator.setFieldExtractor(fieldExtractor);

        return  lineAggregator;
    }

    private FieldExtractor<SettlementDTO> createSettlenmentFieldExtractor(){
        BeanWrapperFieldExtractor<SettlementDTO> extractor = new BeanWrapperFieldExtractor<>();
        extractor.setNames(new String[]{"externalReference", "TransactionAmount"});
        return extractor;
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    ItemWriter<ComprovanteVenda> tofileFixedLength(){

        FlatFileItemWriter<ComprovanteVenda> writer = new FlatFileItemWriter<>();

        writer.setHeaderCallback(new FlatFileHeaderCallback() {

            @Override
            public void writeHeader(Writer writer) throws IOException {

                FlrConfiguration config = new FlrConfiguration();
                config.setLineBreak("");

                Serializer serializer = FlrIOFactory.createFactory(SettlementHeaderFileDTO.class).createSerializer();
                Serializer serializerSubHeader = FlrIOFactory.createFactory(config, SettlementSubHeaderFileDTO.class).createSerializer();

                StringWriter stringWriterHeader = new StringWriter();
                StringWriter stringWriterSubHeader = new StringWriter();

                serializer.open(stringWriterHeader);
                serializerSubHeader.open(stringWriterSubHeader);

                SettlementHeaderFileDTO header = new SettlementHeaderFileDTO();
                SettlementSubHeaderFileDTO subHeader = new SettlementSubHeaderFileDTO();

                serializer.write(header);
                writer.write(stringWriterHeader.toString());

                serializerSubHeader.write(subHeader);
                writer.write(stringWriterSubHeader.toString());
            }
        });

        writer.setResource(outputResource);

//        writer.setAppendAllowed(true);


//        writer.setLineAggregator(new FormatterLineAggregator<ComprovanteVenda>(){
//            {
//                setFieldExtractor(new BeanWrapperFieldExtractor<ComprovanteVenda>(){
//                    {
//                        setNames(new String[]{"codigoRegistro", "identificacaoLoja"});
//                        setFormat("%-2s%-15s");
//                    }
//                });
//            }
//        });

        writer.setLineAggregator(new PassThroughLineAggregator<ComprovanteVenda>() {
            @Override
            public String aggregate(ComprovanteVenda comprovanteVenda) {

                FlrConfiguration config = new FlrConfiguration();
                config.setLineBreak("");

                Serializer serializer = FlrIOFactory.createFactory(config, ComprovanteVenda.class).createSerializer();

                StringWriter stringWriter = new StringWriter();
                serializer.open(stringWriter);
                serializer.write(comprovanteVenda);
                return stringWriter.toString();
            }
        });

        return writer;
    }


    @Bean
    public Step step1(JdbcBatchItemWriter<SettlementDTO> writer) {

        return stepBuilderFactory.get("step1")
                .<SettlementDTO, ComprovanteVenda> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(tofileFixedLength())
                .build();

    }




}
