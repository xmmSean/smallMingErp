package com.smallming.erp.service.order.impl;

import com.smallming.erp.dto.order.CreateOrderResponse;
import com.smallming.erp.dto.order.CreateOrderRequest;
import com.smallming.erp.service.order.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author smallming
 * @Date 2026/5/5 00:48
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        // 下一步实现：
        // 1. 校验参数
        // 2. 生成订单号
        // 3. 计算订单总金额
        // 4. 保存 orders
        // 5. 保存 order_item

        BigDecimal totalAmount = request.getItems().stream()
                .map(item -> item.getQuantity().multiply(item.getUnitPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return CreateOrderResponse.builder()
                .orderId(1L)
                .orderNo("ORD_TEST_001")
                .totalAmount(totalAmount)
                .build();
    }
}
