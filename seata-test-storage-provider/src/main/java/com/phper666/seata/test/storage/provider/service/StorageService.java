package com.phper666.seata.test.storage.provider.service;

import com.phper666.seata.test.account.provider.dto.CommodityDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;


public interface StorageService {

    /**
     * 扣减库存
     */
    ObjectResponse decreaseStorage(CommodityDTO commodityDTO);
}
