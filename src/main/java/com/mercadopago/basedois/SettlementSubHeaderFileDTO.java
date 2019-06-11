package com.mercadopago.basedois;

import net.sf.jsefa.flr.annotation.FlrDataType;
import net.sf.jsefa.flr.annotation.FlrField;
import net.sf.jsefa.flr.lowlevel.Align;

@FlrDataType()
public class SettlementSubHeaderFileDTO {

    @FlrField(pos = 1, length = 2)
    String codigoRegistro = "L0";

    @FlrField(pos = 2, length = 8)
    String dataMovimento = "20190412";

    @FlrField(pos = 3, length = 2)
    String identificacaoMoeda = "RE";

    @FlrField(pos = 4, length = 6, padCharacter = '0', align = Align.RIGHT)
    String nseq = "2";

    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public String getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(String dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public String getIdentificacaoMoeda() {
        return identificacaoMoeda;
    }

    public void setIdentificacaoMoeda(String identificacaoMoeda) {
        this.identificacaoMoeda = identificacaoMoeda;
    }

    public String getNseq() {
        return nseq;
    }

    public void setNseq(String nseq) {
        this.nseq = nseq;
    }
}
