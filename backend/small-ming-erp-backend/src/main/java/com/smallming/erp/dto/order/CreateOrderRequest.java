package com.smallming.erp.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName CreateOrderRequest
 * @Description TODO
 * @Author smallming
 * @Date 2026/5/5 00:13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 购买方用户id
     */
    private Long buyerId;

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 订单明细
     */
    private List<CreateOrderItemRequest> items;
}
