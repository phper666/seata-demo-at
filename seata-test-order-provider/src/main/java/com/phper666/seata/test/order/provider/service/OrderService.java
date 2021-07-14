package com.phper666.seata.test.order.provider.service;

import com.phper666.seata.test.account.provider.dto.OrderDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;


public interface OrderService {

    /**
     * 创建订单
     */
    ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO);
}
