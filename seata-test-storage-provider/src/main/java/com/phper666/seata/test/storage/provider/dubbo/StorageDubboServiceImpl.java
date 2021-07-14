package com.phper666.seata.test.storage.provider.dubbo;


import com.phper666.seata.test.account.provider.dto.CommodityDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;
import com.phper666.seata.test.account.provider.rpc.StorageDubboService;
import com.phper666.seata.test.storage.provider.service.StorageService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
@Slf4j
public class StorageDubboServiceImpl implements StorageDubboService {

    @Autowired
    private StorageService storageService;

    @Override
    public ObjectResponse decreaseStorage(CommodityDTO commodityDTO) {
        log.info("全局事务id ：" + RootContext.getXID());
        return storageService.decreaseStorage(commodityDTO);
    }
}
