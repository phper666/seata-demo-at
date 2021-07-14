package com.phper666.seata.test.account.provider.rpc;

import com.phper666.seata.test.account.provider.dto.CommodityDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;

/**
 * The interface Storage service.
 */
public interface StorageDubboService {

    /**
     * 扣减库存
     */
    ObjectResponse decreaseStorage(CommodityDTO commodityDTO);
}
