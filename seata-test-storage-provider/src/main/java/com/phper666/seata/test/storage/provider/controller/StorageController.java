package com.phper666.seata.test.storage.provider.controller;

import com.phper666.seata.test.account.provider.dto.CommodityDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;
import com.phper666.seata.test.storage.provider.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
@Slf4j
public class StorageController {


    @Autowired
    private StorageService storageService;


    /**
     * 扣减库存
     */
    @PostMapping("dec_storage")
    ObjectResponse decreaseStorage(@RequestBody CommodityDTO commodityDTO){
        log.info("请求库存微服务：{}",commodityDTO.toString());
        return storageService.decreaseStorage(commodityDTO);
    }
}

