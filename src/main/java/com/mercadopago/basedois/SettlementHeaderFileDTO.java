package com.mercadopago.basedois;

import net.sf.jsefa.flr.annotation.FlrDataType;
import net.sf.jsefa.flr.annotation.FlrField;
import net.sf.jsefa.flr.lowlevel.Align;
import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@FlrDataType()
public class SettlementHeaderFileDTO {

    @FlrField(pos = 1, length = 2)
    String codigoRegistro="A0";

    @FlrField(pos=2, length = 6)
    String versaoLayout="001.8a";

    @FlrField(pos=3, length = 8)
    String dataGeracaoArquivo = "20190412";

    @FlrField(pos=4, length = 6)
    String horaGeracaoArquivo = "131522";

    @FlrField(pos=5, length = 6)
    String idMovimentacao = "123456";

    @FlrField(pos=6, length = 30, padCharacter = ' ', align = Align.RIGHT)
    String nomeAdministradora = "MercadoPago";

    @FlrField(pos=7, length = 4)
    String identificacaoRemetente="0000";

    @FlrField(pos=8, length = 6)
    String identificacaoDestinatario="000000";

    @FlrField(pos=9, length = 1)
    String tipoProcessamento = "N";

    @FlrField(pos=10, length = 6)
    String nseqRegistro = "000001";


    public String getIdentificacaoRemetente() {
        return identificacaoRemetente;
    }

    public void setIdentificacaoRemetente(String identificacaoRemetente) {
        this.identificacaoRemetente = identificacaoRemetente;
    }

    public String getIdentificacaoDestinatario() {
        return identificacaoDestinatario;
    }

    public void setIdentificacaoDestinatario(String identificacaoDestinatario) {
        this.identificacaoDestinatario = identificacaoDestinatario;
    }

    public SettlementHeaderFileDTO() {
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public String getVersaoLayout() {
        return versaoLayout;
    }

    public void setVersaoLayout(String versaoLayout) {
        this.versaoLayout = versaoLayout;
    }

    public String getDataGeracaoArquivo() {
        return dataGeracaoArquivo;
    }

    public void setDataGeracaoArquivo(String dataGeracaoArquivo) {
        this.dataGeracaoArquivo = dataGeracaoArquivo;
    }

    public String getHoraGeracaoArquivo() {
        return horaGeracaoArquivo;
    }

    public void setHoraGeracaoArquivo(String horaGeracaoArquivo) {
        this.horaGeracaoArquivo = horaGeracaoArquivo;
    }

    public String getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(String idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public String getNomeAdministradora() {
        return nomeAdministradora;
    }

    public void setNomeAdministradora(String nomeAdministradora) {
        this.nomeAdministradora = nomeAdministradora;
    }

    public String getTipoProcessamento() {
        return tipoProcessamento;
    }

    public void setTipoProcessamento(String tipoProcessamento) {
        this.tipoProcessamento = tipoProcessamento;
    }

    public String getNseqRegistro() {
        return nseqRegistro;
    }

    public void setNseqRegistro(String nseqRegistro) {
        this.nseqRegistro = nseqRegistro;
    }
}
