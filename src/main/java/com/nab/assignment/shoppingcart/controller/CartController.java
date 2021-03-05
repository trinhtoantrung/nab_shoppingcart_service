package com.nab.assignment.shoppingcart.controller;

import com.nab.assignment.shoppingcart.dto.CartDTO;
import com.nab.assignment.shoppingcart.dto.request.AddItemCartDTO;
import com.nab.assignment.shoppingcart.dto.request.UpdateItemCartDTO;
import com.nab.assignment.shoppingcart.service.CartService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{id}")
    public CartDTO getCartDetails(@PathVariable("id") String id) {
        return cartService.getCartDetails(UUID.fromString(id));
    }

    @PostMapping("/create")
    public CartDTO createNewCart() {
        return cartService.create();
    }

    @PostMapping("/add-item")
    public void addItem(@Valid @RequestBody AddItemCartDTO dto) {
        cartService.addItem(UUID.fromString(dto.getCartId()), UUID.fromString(dto.getProductId()));
    }

    @PostMapping("/update-item")
    public void updateItem(@Valid @RequestBody UpdateItemCartDTO dto) {
        cartService.updateItem(UUID.fromString(dto.getCartId()), UUID.fromString(dto.getProductId()), dto.getQuantity());
    }
}
