package com.phper666.seata.test.storage.provider.core.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phper666.seata.test.storage.provider.core.StorageCore;
import com.phper666.seata.test.storage.provider.entity.StorageDO;
import com.phper666.seata.test.storage.provider.mapper.StorageMapper;
import org.springframework.stereotype.Service;

/**
 * @author yuzhao.li
 * @email yuzhao.li@salesforce-china.com
 * @date 5/13/2021
 **/
@Service
public class StorageCoreImpl extends ServiceImpl<StorageMapper, StorageDO> implements StorageCore {
    @Override
    public boolean decreaseStorage(String commodityCode, Integer count) {
        // update t_storage set count = count-${count} where commodity_code = #{commodityCode}
        String sql = "count = count - " + count;
        UpdateWrapper<StorageDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda()
                .setSql(sql)
                .eq(StorageDO::getCommodityCode, commodityCode);
        return update(updateWrapper);
    }
}
