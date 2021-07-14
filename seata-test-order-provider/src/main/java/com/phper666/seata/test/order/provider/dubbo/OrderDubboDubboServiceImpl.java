package com.phper666.seata.test.order.provider.dubbo;

import com.phper666.seata.test.account.provider.dto.OrderDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;
import com.phper666.seata.test.account.provider.rpc.OrderDubboService;
import com.phper666.seata.test.order.provider.service.OrderService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
@Slf4j
public class OrderDubboDubboServiceImpl implements OrderDubboService {
    @Autowired
    private OrderService orderService;

    @Override
    public ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO) {
        log.info("全局事务id ：" + RootContext.getXID());
        return orderService.createOrder(orderDTO);
    }
}
