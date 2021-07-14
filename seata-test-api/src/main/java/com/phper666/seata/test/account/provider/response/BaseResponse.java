package com.phper666.seata.test.account.provider.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse implements Serializable {

    private int status = 200;

    private String message;
}
