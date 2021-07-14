package com.phper666.seata.test.account.provider.rpc;

import com.phper666.seata.test.account.provider.dto.AccountDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;

/**
 * The interface Account service.
 */
public interface AccountDubboService {

    /**
     * 余额扣款
     *
     * @return
     */
    ObjectResponse decreaseAccount(AccountDTO accountDTO);
}
