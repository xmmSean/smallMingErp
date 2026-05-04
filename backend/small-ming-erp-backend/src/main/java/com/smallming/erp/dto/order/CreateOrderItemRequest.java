package com.smallming.erp.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName CreatOrderItemRequest
 * @Description TODO
 * @Author smallming
 * @Date 2026/5/5 00:21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderItemRequest {

    /**
     * 库存id
     */
    private Long inventoryId;

    /**
     * 商品sku id
     */
    private Long skuId;

    /**
     * 购买数量
     */
    private BigDecimal quantity;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

}
