package com.smallming.erp.domain.order;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @ClassName Order
 * @Description TODO
 * @Author smallming
 * @Date 2026/6/22 19:31
 **/
@Data
@Builder
public class Order {
    private Long tenantId;

    private Long id;

    private String orderNo;

    private Long buyerId;

    private Long accountId;

    private Integer state;

    private BigDecimal totalAmount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
