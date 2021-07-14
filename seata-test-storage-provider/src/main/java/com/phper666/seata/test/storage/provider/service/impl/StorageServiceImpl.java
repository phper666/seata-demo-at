package com.phper666.seata.test.storage.provider.service.impl;


import com.phper666.seata.test.account.provider.dto.CommodityDTO;
import com.phper666.seata.test.account.provider.enums.RspStatusEnum;
import com.phper666.seata.test.account.provider.response.ObjectResponse;
import com.phper666.seata.test.storage.provider.core.StorageCore;
import com.phper666.seata.test.storage.provider.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageCore storageCore;

    @Override
    public ObjectResponse decreaseStorage(CommodityDTO commodityDTO) {
        boolean storage = storageCore.decreaseStorage(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (storage){
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }
}
