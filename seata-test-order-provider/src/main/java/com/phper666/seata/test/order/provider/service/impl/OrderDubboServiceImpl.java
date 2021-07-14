package com.phper666.seata.test.order.provider.service.impl;

import com.phper666.seata.test.account.provider.dto.AccountDTO;
import com.phper666.seata.test.account.provider.dto.OrderDTO;
import com.phper666.seata.test.account.provider.enums.RspStatusEnum;
import com.phper666.seata.test.account.provider.response.ObjectResponse;
import com.phper666.seata.test.account.provider.rpc.AccountDubboService;
import com.phper666.seata.test.order.provider.core.OrderCore;
import com.phper666.seata.test.order.provider.entity.OrderDO;
import com.phper666.seata.test.order.provider.service.OrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class OrderDubboServiceImpl implements OrderService {

    @DubboReference(check = false)
    private AccountDubboService accountDubboService;

    @Autowired
    private OrderCore orderCore;

    /**
     * 创建订单
     * @Param:  OrderDTO  订单对象
     * @Return:  OrderDTO  订单对象
     */
    @Override
    public ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO) {
        ObjectResponse<OrderDTO> response = new ObjectResponse<>();
        //扣减用户账户
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(orderDTO.getUserId());
        accountDTO.setAmount(orderDTO.getOrderAmount());
        ObjectResponse objectResponse = accountDubboService.decreaseAccount(accountDTO);

        //生成订单号
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        //生成订单
        OrderDO order = new OrderDO();
        BeanUtils.copyProperties(orderDTO, order);
        order.setCount(orderDTO.getOrderCount());
        order.setAmount(orderDTO.getOrderAmount().doubleValue());
        try {
            orderCore.createOrder(order);
        } catch (Exception e) {
            response.setStatus(RspStatusEnum.FAIL.getCode());
            response.setMessage(RspStatusEnum.FAIL.getMessage());
            return response;
        }

        if (objectResponse.getStatus() != 200) {
            response.setStatus(RspStatusEnum.FAIL.getCode());
            response.setMessage(RspStatusEnum.FAIL.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.SUCCESS.getCode());
        response.setMessage(RspStatusEnum.SUCCESS.getMessage());
        return response;
    }
}
