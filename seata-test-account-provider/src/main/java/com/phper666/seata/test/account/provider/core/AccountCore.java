package com.phper666.seata.test.account.provider.core;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phper666.seata.test.account.provider.entity.AccountDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuzhao.li
 * @email yuzhao.li@salesforce-china.com
 * @date 5/13/2021
 **/
public interface AccountCore extends IService<AccountDO> {
    boolean decreaseAccount(@Param("userId") String userId, @Param("amount") Double amount);
}
