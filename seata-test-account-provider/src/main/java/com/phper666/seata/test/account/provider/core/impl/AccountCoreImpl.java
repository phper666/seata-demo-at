package com.phper666.seata.test.account.provider.core.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phper666.seata.test.account.provider.core.AccountCore;
import com.phper666.seata.test.account.provider.entity.AccountDO;
import com.phper666.seata.test.account.provider.mapper.AccountMapper;
import org.springframework.stereotype.Service;

/**
 * @author yuzhao.li
 * @email yuzhao.li@salesforce-china.com
 * @date 5/13/2021
 **/
@Service
public class AccountCoreImpl extends ServiceImpl<AccountMapper, AccountDO> implements AccountCore {
    @Override
    public boolean decreaseAccount(String userId, Double amount) {
        // update t_account set amount = amount-${amount} where user_id = #{userId}
        String sql = "amount = amount - " + amount;
        UpdateWrapper<AccountDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda()
                .setSql(sql)
                .eq(AccountDO::getUserId, userId);
        return update(updateWrapper);
    }
}
