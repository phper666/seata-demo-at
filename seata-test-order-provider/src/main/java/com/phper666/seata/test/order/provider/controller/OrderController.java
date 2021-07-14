package com.phper666.seata.test.order.provider.controller;

import com.phper666.seata.test.account.provider.dto.OrderDTO;
import com.phper666.seata.test.account.provider.response.ObjectResponse;
import com.phper666.seata.test.order.provider.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create_order")
    ObjectResponse<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
        log.info("请求订单微服务：{}",orderDTO.toString());
        return orderService.createOrder(orderDTO);
    }
}

