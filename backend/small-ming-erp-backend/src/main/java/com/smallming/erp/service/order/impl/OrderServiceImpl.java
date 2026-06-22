package com.smallming.erp.service.order.impl;

import com.smallming.erp.domain.order.Order;
import com.smallming.erp.domain.order.OrderItem;
import com.smallming.erp.dto.order.CreateOrderItemRequest;
import com.smallming.erp.dto.order.CreateOrderRequest;
import com.smallming.erp.dto.order.CreateOrderResponse;
import com.smallming.erp.mapper.order.OrderItemMapper;
import com.smallming.erp.mapper.order.OrderMapper;
import com.smallming.erp.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private static final int ORDER_STATE_WAIT_PAY = 1;

    private final OrderMapper orderMapper;

    private final OrderItemMapper orderItemMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        validateRequest(request);

        Long orderId = generateId();
        String orderNo = generateOrderNo();
        LocalDateTime now = LocalDateTime.now();

        BigDecimal totalAmount = calculateTotalAmount(request);

        Order order = Order.builder()
                .tenantId(request.getTenantId())
                .id(orderId)
                .orderNo(orderNo)
                .buyerId(request.getBuyerId())
                .accountId(request.getAccountId())
                .state(ORDER_STATE_WAIT_PAY)
                .totalAmount(totalAmount)
                .createdAt(now)
                .updatedAt(now)
                .build();

        int orderInserted = orderMapper.insert(order);
        if (orderInserted != 1) {
            throw new RuntimeException("创建订单失败");
        }

        for (CreateOrderItemRequest itemRequest : request.getItems()) {
            BigDecimal itemTotalAmount = itemRequest.getQuantity()
                    .multiply(itemRequest.getUnitPrice());

            OrderItem orderItem = OrderItem.builder()
                    .tenantId(request.getTenantId())
                    .id(generateId())
                    .orderId(orderId)
                    .inventoryId(itemRequest.getInventoryId())
                    .skuId(itemRequest.getSkuId())
                    .quantity(itemRequest.getQuantity())
                    .unitPrice(itemRequest.getUnitPrice())
                    .totalAmount(itemTotalAmount)
                    .createdAt(now)
                    .build();

            int itemInserted = orderItemMapper.insert(orderItem);
            if (itemInserted != 1) {
                throw new RuntimeException("创建订单明细失败");
            }
        }

        return CreateOrderResponse.builder()
                .orderId(orderId)
                .orderNo(orderNo)
                .totalAmount(totalAmount)
                .build();
    }

    private void validateRequest(CreateOrderRequest request) {
        if (request == null) {
            throw new RuntimeException("请求不能为空");
        }
        if (request.getTenantId() == null) {
            throw new RuntimeException("租户id不能为空");
        }
        if (request.getBuyerId() == null) {
            throw new RuntimeException("购买方不能为空");
        }
        if (request.getAccountId() == null) {
            throw new RuntimeException("账户不能为空");
        }
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new RuntimeException("订单明细不能为空");
        }

        for (CreateOrderItemRequest item : request.getItems()) {
            if (item.getInventoryId() == null) {
                throw new RuntimeException("库存id不能为空");
            }
            if (item.getSkuId() == null) {
                throw new RuntimeException("skuId不能为空");
            }
            if (item.getQuantity() == null || item.getQuantity().compareTo(BigDecimal.ZERO) <= 0) {
                throw new RuntimeException("购买数量必须大于0");
            }
            if (item.getUnitPrice() == null || item.getUnitPrice().compareTo(BigDecimal.ZERO) < 0) {
                throw new RuntimeException("单价不能小于0");
            }
        }
    }

    private BigDecimal calculateTotalAmount(CreateOrderRequest request) {
        return request.getItems().stream()
                .map(item -> item.getQuantity().multiply(item.getUnitPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Long generateId() {
        return System.currentTimeMillis();
    }

    private String generateOrderNo() {
        String time = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        return "ORD" + time;
    }
}