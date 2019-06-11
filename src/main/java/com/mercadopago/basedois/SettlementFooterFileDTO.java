package com.mercadopago.basedois;

import net.sf.jsefa.flr.annotation.FlrDataType;
import net.sf.jsefa.flr.annotation.FlrField;
import net.sf.jsefa.flr.lowlevel.Align;

@FlrDataType()
public class SettlementFooterFileDTO {

    @FlrField(pos = 1, length = 2)
    String codigoRegistro = "A9";


    @FlrField(pos = 2, length = 6, padCharacter = '0', align = Align.RIGHT)
    String totalGeralRegistros;

    @FlrField(pos = 3, length = 6, padCharacter = '0', align = Align.RIGHT)
    String nseq = "0";


    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public String getTotalGeralRegistros() {
        return totalGeralRegistros;
    }

    public void setTotalGeralRegistros(String totalGeralRegistros) {
        this.totalGeralRegistros = totalGeralRegistros;
    }

    public String getNseq() {

        Integer totalRegs = new Integer(this.totalGeralRegistros);
        totalRegs += 3;

        this.nseq = totalRegs.toString();

        return nseq;
    }

    public void setNseq(String nseq) {
        this.nseq = nseq;
    }
}
