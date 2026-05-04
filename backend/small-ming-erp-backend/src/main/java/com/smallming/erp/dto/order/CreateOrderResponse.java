package com.smallming.erp.dto.order;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName CreatOrderResponse
 * @Description TODO
 * @Author smallming
 * @Date 2026/5/5 00:33
 **/
@Builder
@Data
public class CreateOrderResponse {

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;


}
