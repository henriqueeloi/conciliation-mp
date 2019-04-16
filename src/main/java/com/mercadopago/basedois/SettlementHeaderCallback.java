package com.mercadopago.basedois;

import net.sf.jsefa.Serializer;
import net.sf.jsefa.flr.FlrIOFactory;
import org.springframework.batch.item.file.FlatFileHeaderCallback;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class SettlementHeaderCallback implements FlatFileHeaderCallback {
    @Override
    public void writeHeader(Writer writer) throws IOException {

//        Serializer serializer = FlrIOFactory.createFactory(SettlementHeaderFileDTO.class).createSerializer();
//        StringWriter stringWriter = new StringWriter();
//
//        serializer.open(stringWriter);
//
//        SettlementHeaderFileDTO header = new SettlementHeaderFileDTO();
//        serializer.write(header);
//
//        writer.write(stringWriter.toString());
    }
}
