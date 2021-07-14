package com.phper666.seata.test.account.provider.rpc;


import com.phper666.seata.test.account.provider.dto.OrderDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;

/**
 * <p>
 *  创建订单
 * </p>
 *
 * * @author lidong
 * @since 2019-09-04
 */
public interface OrderDubboService {

    /**
     * 创建订单
     */
    ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO);
}
