package com.phper666.seata.test.storage.provider.core;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phper666.seata.test.storage.provider.entity.StorageDO;

/**
 * @author yuzhao.li
 * @email yuzhao.li@salesforce-china.com
 * @date 5/13/2021
 **/
public interface StorageCore extends IService<StorageDO> {
    /**
     * 扣减商品库存
     * @Param: commodityCode 商品code  count扣减数量
     * @Return:
     */
    boolean decreaseStorage(String commodityCode, Integer count);
}
