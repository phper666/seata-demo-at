package com.phper666.seata.test.account.provider.service;

import com.phper666.seata.test.account.provider.dto.AccountDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;

public interface AccountService {

    /**
     * 扣用户钱
     */
    ObjectResponse decreaseAccount(AccountDTO accountDTO);
}
