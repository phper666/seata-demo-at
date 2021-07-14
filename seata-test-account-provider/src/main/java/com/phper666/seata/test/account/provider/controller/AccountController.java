package com.phper666.seata.test.account.provider.controller;

import com.phper666.seata.test.account.provider.dto.AccountDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;
import com.phper666.seata.test.account.provider.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/dec_account")
    ObjectResponse decreaseAccount(@RequestBody AccountDTO accountDTO) {
        log.info("请求账户微服务：{}", accountDTO.toString());
        return accountService.decreaseAccount(accountDTO);
    }
}

