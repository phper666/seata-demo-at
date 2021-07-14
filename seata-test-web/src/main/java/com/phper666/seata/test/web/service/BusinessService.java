package com.phper666.seata.test.web.service;


import com.phper666.seata.test.account.provider.dto.BusinessDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;

public interface BusinessService {

    /**
     * 出处理业务服务
      * @param businessDTO
     * @return
     */
    ObjectResponse handleBusiness(BusinessDTO businessDTO);


    /**
     * 出处理业务服务，出现异常回顾
     * @param businessDTO
     * @return
     */
    ObjectResponse handleBusiness2(BusinessDTO businessDTO, boolean flag);
}
