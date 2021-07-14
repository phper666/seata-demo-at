package com.phper666.seata.test.account.provider.dubbo;

import com.phper666.seata.test.account.provider.dto.AccountDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;
import com.phper666.seata.test.account.provider.rpc.AccountDubboService;
import com.phper666.seata.test.account.provider.service.AccountService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
@Slf4j
public class AccountDubboServiceImpl implements AccountDubboService {

    @Autowired
    private AccountService accountService;

    @Override
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        log.info("全局事务id ：" + RootContext.getXID());
        return accountService.decreaseAccount(accountDTO);
    }
}
