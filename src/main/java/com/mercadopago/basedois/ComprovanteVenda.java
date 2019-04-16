package com.mercadopago.basedois;

import net.sf.jsefa.flr.annotation.FlrDataType;
import net.sf.jsefa.flr.annotation.FlrField;
import net.sf.jsefa.flr.lowlevel.Align;

@FlrDataType()
public class ComprovanteVenda {

    @FlrField(pos = 1, length = 2)
    String codigoRegistro="CV";

    @FlrField(pos = 2, length = 15, padCharacter = '0', align = Align.RIGHT)
    String identificacaoLoja;

    @FlrField(pos = 3, length = 12, padCharacter = '0', align = Align.RIGHT)
    String nsuHostTransacao;

    @FlrField(pos = 4, length = 8)
    String dataTransacao;

    @FlrField(pos = 5, length = 6)
    String horarioTransacao;

    @FlrField(pos = 6, length = 1)
    String tipoLancamento="1";

    @FlrField(pos = 7, length = 8)
    String dataLancamento;

    @FlrField(pos = 8, length = 1)
    String tipoProduto;

    @FlrField(pos = 9, length = 1)
    String meioCaptura="3";

    @FlrField(pos = 10, length = 11, padCharacter = '0', align = Align.RIGHT)
    String valorBrutoVenda;

    @FlrField(pos = 11, length = 11, padCharacter = '0', align = Align.RIGHT)
    String valorDesconto;

//    @FlrField(pos = 12, length = 11)
//    String valorTaxaAntecipacao;

    @FlrField(pos = 13, length = 11, padCharacter = '0', align = Align.RIGHT)
    String valorLiqVenda;

    @FlrField(pos = 14, length = 19, padCharacter = '0', align = Align.RIGHT)
    String numeroCartao;

    @FlrField(pos = 15, length = 2)
    String numeroParcela;

    @FlrField(pos = 16, length = 2)
    String numeroTotalParcelas;

    @FlrField(pos = 17, length = 12, padCharacter = '0', align = Align.RIGHT)
    String reservado;

    @FlrField(pos = 18, length = 11, padCharacter = '0', align = Align.RIGHT)
    String valorbrutoParcela;

    @FlrField(pos = 19, length = 11, padCharacter = '0', align = Align.RIGHT)
    String valorDescontoParcela;

    @FlrField(pos = 20, length = 11, padCharacter = '0', align = Align.RIGHT)
    String valorLiquidoParcela;

//    @FlrField(pos = 21, length = 11, padCharacter = '0', align = Align.RIGHT)
//    String valorTaxaAntecipacaoParcela;

    @FlrField(pos = 22, length = 3)
    String banco;

    @FlrField(pos = 23, length = 6, padCharacter = '0', align = Align.RIGHT)
    String agencia;

    @FlrField(pos = 24, length = 11, padCharacter = '0', align = Align.RIGHT)
    String conta;

    @FlrField(pos = 25, length = 12, padCharacter = '0', align = Align.RIGHT)
    String codigoAutorizacao;

//    @FlrField(pos = 26, length = 3)
//    String codigoBandeira;
//
//    @FlrField(pos = 27, length = 3)
//    String codigoProduto;

    @FlrField(pos = 28, length = 6, padCharacter = '0', align = Align.RIGHT)
    String nseq;


    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public String getIdentificacaoLoja() {
        return identificacaoLoja;
    }

    public void setIdentificacaoLoja(String identificacaoLoja) {
        this.identificacaoLoja = identificacaoLoja;
    }

    public String getNsuHostTransacao() {
        return nsuHostTransacao;
    }

    public void setNsuHostTransacao(String nsuHostTransacao) {
        this.nsuHostTransacao = nsuHostTransacao;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getHorarioTransacao() {
        return horarioTransacao;
    }

    public void setHorarioTransacao(String horarioTransacao) {
        this.horarioTransacao = horarioTransacao;
    }

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getMeioCaptura() {
        return meioCaptura;
    }

    public void setMeioCaptura(String meioCaptura) {
        this.meioCaptura = meioCaptura;
    }

    public String getValorBrutoVenda() {
        return valorBrutoVenda;
    }

    public void setValorBrutoVenda(String valorBrutoVenda) {
        this.valorBrutoVenda = valorBrutoVenda;
    }

    public String getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(String valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getValorLiqVenda() {
        return valorLiqVenda;
    }

    public void setValorLiqVenda(String valorLiqVenda) {
        this.valorLiqVenda = valorLiqVenda;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(String numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public String getNumeroTotalParcelas() {
        return numeroTotalParcelas;
    }

    public void setNumeroTotalParcelas(String numeroTotalParcelas) {
        this.numeroTotalParcelas = numeroTotalParcelas;
    }

    public String getReservado() {
        return reservado;
    }

    public void setReservado(String reservado) {
        this.reservado = reservado;
    }

    public String getValorbrutoParcela() {
        return valorbrutoParcela;
    }

    public void setValorbrutoParcela(String valorbrutoParcela) {
        this.valorbrutoParcela = valorbrutoParcela;
    }

    public String getValorDescontoParcela() {
        return valorDescontoParcela;
    }

    public void setValorDescontoParcela(String valorDescontoParcela) {
        this.valorDescontoParcela = valorDescontoParcela;
    }

    public String getValorLiquidoParcela() {
        return valorLiquidoParcela;
    }

    public void setValorLiquidoParcela(String valorLiquidoParcela) {
        this.valorLiquidoParcela = valorLiquidoParcela;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getCodigoAutorizacao() {
        return codigoAutorizacao;
    }

    public void setCodigoAutorizacao(String codigoAutorizacao) {
        this.codigoAutorizacao = codigoAutorizacao;
    }

    public String getNseq() {
        return nseq;
    }

    public void setNseq(String nseq) {
        this.nseq = nseq;
    }
}
