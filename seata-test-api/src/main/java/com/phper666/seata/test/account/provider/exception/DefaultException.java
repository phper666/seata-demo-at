package com.phper666.seata.test.account.provider.exception;


import com.phper666.seata.test.account.provider.enums.RspStatusEnum;

public class DefaultException extends RuntimeException{

    private RspStatusEnum rspStatusEnum;

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultException(RspStatusEnum rspStatusEnum) {
        super(rspStatusEnum.getMessage());
        this.rspStatusEnum = rspStatusEnum;
    }

    public DefaultException(RspStatusEnum rspStatusEnum, Throwable cause) {
        super(rspStatusEnum.getMessage(), cause);
        this.rspStatusEnum = rspStatusEnum;
    }

    public RspStatusEnum getRspStatusEnum() {
        return rspStatusEnum;
    }

    public void setRspStatusEnum(RspStatusEnum rspStatusEnum) {
        this.rspStatusEnum = rspStatusEnum;
    }
}
