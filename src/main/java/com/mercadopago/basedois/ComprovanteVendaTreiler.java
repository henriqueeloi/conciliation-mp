package com.mercadopago.basedois;

import com.github.ffpojo.file.processor.FlatFileProcessor;
import com.github.ffpojo.file.processor.record.RecordProcessor;
import com.github.ffpojo.file.processor.record.handler.ErrorHandler;
import net.sf.jsefa.Serializer;
import net.sf.jsefa.flr.FlrIOFactory;
import net.sf.jsefa.flr.config.FlrConfiguration;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileFooterCallback;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class ComprovanteVendaTreiler  extends StepExecutionListenerSupport implements FlatFileFooterCallback {

    private StepExecution stepExecution;


    @Override
    public void writeFooter(Writer writer) throws IOException {

        ExecutionContext stepContext = this.stepExecution.getExecutionContext();
        Integer totalRegs = new Integer(stepExecution.getWriteCount());

        //Sub Footer

         writer.write(getSubFooter(writer, totalRegs));


        //Footer

        writer.write(getFooter(writer, totalRegs));

    }

    private String getFooter(Writer writer, Integer totalRegs) {

        FlrConfiguration config = new FlrConfiguration();
        config.setLineBreak("");

        Serializer serializer = FlrIOFactory.createFactory(config, SettlementFooterFileDTO.class).createSerializer();
        StringWriter stringWriter = new StringWriter();

        totalRegs += 4;
        SettlementFooterFileDTO footerFileDTO = new SettlementFooterFileDTO();
        footerFileDTO.setTotalGeralRegistros(String.valueOf(totalRegs));


        footerFileDTO.setNseq(totalRegs.toString());

        serializer.open(stringWriter);
        serializer.write(footerFileDTO);

        return stringWriter.toString();
    }

    private String getSubFooter(Writer writer, Integer totalRegs) throws IOException {

        Serializer serializer = FlrIOFactory.createFactory(SettlementFooterLoteDTO.class).createSerializer();
        StringWriter stringWriter = new StringWriter();
        totalRegs += 3;

        SettlementFooterLoteDTO footerFileDTO = new SettlementFooterLoteDTO();
        footerFileDTO.setTotalRegistrosTransacoes(totalRegs.toString());
        footerFileDTO.setTotalValoresCreditos("530");


        footerFileDTO.setNseq(totalRegs.toString());

        serializer.open(stringWriter);
        serializer.write(footerFileDTO);

        return stringWriter.toString();
    }

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

}
