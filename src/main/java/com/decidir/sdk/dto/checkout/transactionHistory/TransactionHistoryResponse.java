package com.decidir.sdk.dto.checkout.transactionHistory;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.ArrayList;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TransactionHistoryResponse extends ArrayList<TransactionDto> {
    private static final long serialVersionUID = 1L;

}