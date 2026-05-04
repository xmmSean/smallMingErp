package com.smallming.erp.service.order;

import com.smallming.erp.dto.order.CreateOrderResponse;
import com.smallming.erp.dto.order.CreateOrderRequest;

/**
 * @InterfaceName OrderService
 * @Description TODO
 * @Author smallming
 * @Date 2026/5/5 00:47
 **/
public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest request);
}
