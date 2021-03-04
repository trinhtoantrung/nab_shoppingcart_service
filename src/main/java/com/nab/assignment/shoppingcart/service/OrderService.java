package com.nab.assignment.shoppingcart.service;

import com.nab.assignment.shoppingcart.constant.OrderStatus;
import com.nab.assignment.shoppingcart.dto.OrderDTO;

import java.util.UUID;

public interface OrderService {
    OrderDTO getOrderDetails(UUID id);
    void processOrder(UUID id, OrderStatus status, Boolean isPaid);
}
