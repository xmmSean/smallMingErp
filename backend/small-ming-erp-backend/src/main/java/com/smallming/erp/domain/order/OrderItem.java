package com.smallming.erp.domain.order;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @ClassName OrderItem
 * @Description TODO
 * @Author smallming
 * @Date 2026/6/22 19:35
 **/
@Data
@Builder
public class OrderItem {
    private Long tenantId;

    private Long id;

    private Long orderId;

    private Long inventoryId;

    private Long skuId;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalAmount;

    private LocalDateTime createdAt;
}
