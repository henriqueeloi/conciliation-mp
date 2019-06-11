package com.mercadopago.basedois;

import net.sf.jsefa.flr.annotation.FlrDataType;
import net.sf.jsefa.flr.annotation.FlrField;
import net.sf.jsefa.flr.lowlevel.Align;

@FlrDataType()
public class SettlementFooterLoteDTO {

    @FlrField(pos = 1, length = 2)
    String codigoRegistro = "L9";


    @FlrField(pos = 2, length = 6, padCharacter = '0', align = Align.RIGHT)
    String totalRegistrosTransacoes;

    @FlrField(pos = 3, length = 14, padCharacter = '0', align = Align.RIGHT)
    String totalValoresCreditos;

    @FlrField(pos = 4, length = 6, padCharacter = '0', align = Align.RIGHT)
    String nseq = "0";


    public String getTotalRegistrosTransacoes() {
        return totalRegistrosTransacoes;
    }

    public void setTotalRegistrosTransacoes(String totalRegistrosTransacoes) {
        this.totalRegistrosTransacoes = totalRegistrosTransacoes;
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }


    public String getTotalValoresCreditos() {
        return totalValoresCreditos;
    }

    public void setTotalValoresCreditos(String totalValoresCreditos) {
        this.totalValoresCreditos = totalValoresCreditos;
    }

    public String getNseq() {
        return nseq;
    }

    public void setNseq(String nseq) {
        this.nseq = nseq;
    }
}
