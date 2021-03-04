package com.nab.assignment.shoppingcart.service;

import com.nab.assignment.shoppingcart.dto.CartDTO;
import com.nab.assignment.shoppingcart.dto.OrderDTO;

import java.util.UUID;

public interface CartService {
    CartDTO getCartDetails(UUID id);
    CartDTO create();
    CartDTO addItem(UUID orderId, UUID productId);
    CartDTO updateItemQuantity(UUID orderId, UUID productId, Long quantity);

    OrderDTO createOrder(UUID cartId, String userId, String name, String address, String mobilePhone, String email);
}
