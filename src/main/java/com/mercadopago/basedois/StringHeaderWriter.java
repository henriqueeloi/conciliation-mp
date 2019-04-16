package com.mercadopago.basedois;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

import java.io.IOException;
import java.io.Writer;

public class StringHeaderWriter implements FlatFileHeaderCallback {

    private final SettlementHeaderFileDTO header;

    public StringHeaderWriter(SettlementHeaderFileDTO header) {
        this.header = header;
    }

    @Override
    public void writeHeader(Writer writer) throws IOException {

        writer.write(header.codigoRegistro);
    }
}
