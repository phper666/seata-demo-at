package com.phper666.seata.test.account.provider.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AccountDTO implements Serializable {
    private Integer id;

    private String userId;

    private BigDecimal amount;
}
