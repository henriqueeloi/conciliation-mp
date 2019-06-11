package com.mercadopago.basedois;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SettlementProcessor implements ItemProcessor<SettlementDTO, ComprovanteVenda> {

    private static final Logger log = LoggerFactory.getLogger(SettlementItemProcessor.class);

    private StepExecution stepExecution;

    private Integer sequenNumber=2;

    @Nullable
    @Override
    public ComprovanteVenda process(SettlementDTO settlementDTO) throws Exception {

        ComprovanteVenda comprovanteVenda = new ComprovanteVenda();

        if(!settlementDTO.getTransactionType().equalsIgnoreCase("SETTLEMENT")){
            return  null;
        }

        comprovanteVenda.setIdentificacaoLoja("57926918000183");
        comprovanteVenda.setNsuHostTransacao(settlementDTO.getSourceId());
        comprovanteVenda.setDataTransacao(getDateFormat(settlementDTO.getTransactionDate()));
        comprovanteVenda.setHorarioTransacao(getHourFormat(settlementDTO.getTransactionDate()));
        comprovanteVenda.setDataLancamento(getReleaseDate(settlementDTO.getTransactionDate()));
//      comprovanteVenda.setTipoProduto(getPaymentMethodType(settlementDTO.getPaymentMethodType()));

        comprovanteVenda.setValorBrutoVenda(getValueFormat(settlementDTO.getTransactionAmount()));
        comprovanteVenda.setValorDesconto(getValueFormat(settlementDTO.getFeeAmount()));
        comprovanteVenda.setValorLiqVenda(getValueFormat(settlementDTO.getRealAmount()));

        //comprovanteVenda.setNumeroCartao(getCardNumberByMethodType(settlementDTO.getPaymentMethodType()));
        comprovanteVenda.setNumeroParcela("00");
        comprovanteVenda.setNumeroTotalParcelas("00");
        comprovanteVenda.setReservado("0");
        comprovanteVenda.setValorbrutoParcela("0");
        comprovanteVenda.setValorDescontoParcela("0");
        comprovanteVenda.setValorLiquidoParcela("0");
        comprovanteVenda.setCodigoProduto(getProductCode(settlementDTO.getPaymentMethodType()));

        sequenNumber += 1;
        comprovanteVenda.setNseq(sequenNumber.toString());

        return comprovanteVenda;
    }



    private String getProductCode(String paymentMethodType) {
    	 String type = getPaymentMethodType(paymentMethodType);

         if(type.equalsIgnoreCase("C")){
             return "002";
         }else {
             return "001";
         }
	}



	private String getCardNumberByMethodType(String paymentMethodType) {
        String type = getPaymentMethodType(paymentMethodType);

        if(type.equalsIgnoreCase("C")){
            return "523421******7800";
        }else {
            return "0";
        }
    }

    private String getValueFormat(String transactionAmount) {
        BigDecimal value = new BigDecimal(transactionAmount);
        return value.abs().toString().replace(".","");
    }

    private String getPaymentMethodType(String paymentMethodType) {

        switch (paymentMethodType){
            case "credit_card":
                return "C";
            case "account_money":
                return "V";
            default:
                return "";
        }

    }

    private String getDateFormat(String transactionDate) throws ParseException {
        DateFormat dataF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Format formatter = new SimpleDateFormat("yyyyMMdd");

        Date dateFomat = dataF.parse(transactionDate);

       return formatter.format(dateFomat);

    }

    private String getReleaseDate(String transactionDate) throws ParseException {
        DateFormat dataF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Format formatter = new SimpleDateFormat("yyyyMMdd");

        Date dateFomat = dataF.parse(transactionDate);
        Calendar cDate = Calendar.getInstance();
        cDate.setTime(dateFomat);
        cDate.add(Calendar.DAY_OF_MONTH, 3);

       return formatter.format(cDate.getTime());

    }



    private String getHourFormat(String transactionDate) throws ParseException {
        DateFormat dataF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Format formatter = new SimpleDateFormat("HHmmss");

        Date dateFomat = dataF.parse(transactionDate);

       return formatter.format(dateFomat);

    }
}
