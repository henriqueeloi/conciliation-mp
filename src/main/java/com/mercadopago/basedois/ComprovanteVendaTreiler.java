package com.mercadopago.basedois;

import com.github.ffpojo.file.processor.FlatFileProcessor;
import com.github.ffpojo.file.processor.record.RecordProcessor;
import com.github.ffpojo.file.processor.record.handler.ErrorHandler;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileFooterCallback;

import java.io.IOException;
import java.io.Writer;

public class ComprovanteVendaTreiler  extends StepExecutionListenerSupport implements FlatFileFooterCallback {

    private StepExecution stepExecution;


    @Override
    public void writeFooter(Writer writer) throws IOException {

        ExecutionContext stepContext = this.stepExecution.getExecutionContext();
        

        writer.write("# Write count: "
            + stepExecution.getWriteCount());

        writer.write(System.getProperty("line.separator"));

        long delta = stepExecution.getEndTime().getTime();
        writer.write("# Done in: " + delta + "ms");
    }

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

}
