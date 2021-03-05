package com.nab.assignment.shoppingcart.service;

import com.nab.assignment.shoppingcart.constant.OrderStatus;
import com.nab.assignment.shoppingcart.dto.OrderDTO;

import java.util.UUID;

public interface OrderService {
    OrderDTO createOrder(UUID cartId, String userId, String name, String address, String mobilePhone, String email);
    OrderDTO getOrderDetails(UUID id);
    void processOrder(UUID id, OrderStatus status, Boolean isPaid);
}
