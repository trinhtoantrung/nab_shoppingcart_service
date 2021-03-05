package com.nab.assignment.shoppingcart.service;

import com.nab.assignment.shoppingcart.constant.OrderStatus;
import com.nab.assignment.shoppingcart.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDTO createOrder(UUID cartId, String userId, String name, String address, String mobilePhone, String email) {
        return null;
    }

    @Override
    public OrderDTO getOrderDetails(UUID id) {
        return null;
    }

    @Override
    public void processOrder(UUID id, OrderStatus status, Boolean isPaid) {

    }
}
