package com.mercadopago.basedois;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.Nullable;


public class SettlementItemProcessor implements ItemProcessor<SettlementDTO, SettlementDTO> {

    private static final Logger log = LoggerFactory.getLogger(SettlementItemProcessor.class);

    @Nullable
    @Override
    public SettlementDTO process(SettlementDTO settlementDTO) throws Exception {

        String externalRef = settlementDTO.getExternalReference().toUpperCase();

        String transactionAmount = StringUtils.leftPad(settlementDTO.getTransactionAmount(), 11, "0");

        final SettlementDTO settlementParser = new SettlementDTO();

        settlementParser.setExternalReference(externalRef);
        settlementParser.setTransactionAmount(transactionAmount);


        log.info("Convertendo (" + settlementDTO.getTransactionAmount() + ") em (" + settlementParser.getTransactionAmount() + ")");

        return settlementParser;
    }
}
