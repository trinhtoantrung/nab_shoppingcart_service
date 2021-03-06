package com.nab.assignment.shoppingcart.service;

import com.nab.assignment.shoppingcart.dto.CartDTO;

import java.util.UUID;

public interface CartService {
    CartDTO getCartDetails(UUID id);
    CartDTO create();
    void addNewItem(UUID cartId, UUID productId);
    void updateItem(UUID cartId, UUID productId, Long quantity); // quantity = 0 => REMOVE
}
