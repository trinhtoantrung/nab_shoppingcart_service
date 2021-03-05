package com.nab.assignment.shoppingcart.service;

import com.nab.assignment.shoppingcart.dto.CartDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    @Override
    public CartDTO getCartDetails(UUID id) {
        return null;
    }

    @Override
    public CartDTO create() {
        return null;
    }

    @Override
    public void addItem(UUID orderId, UUID productId) {
    }

    @Override
    public void updateItem(UUID orderId, UUID productId, Long quantity) {
    }
}
