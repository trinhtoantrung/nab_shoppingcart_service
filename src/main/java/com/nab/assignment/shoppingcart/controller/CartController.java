package com.nab.assignment.shoppingcart.controller;

import com.nab.assignment.shoppingcart.dto.CartDTO;
import com.nab.assignment.shoppingcart.dto.request.AddNewItemCartDTO;
import com.nab.assignment.shoppingcart.dto.request.UpdateItemCartDTO;
import com.nab.assignment.shoppingcart.service.CartService;
import com.nab.assignment.shoppingcart.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/cart")
public class CartController {
    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public CartDTO getCartDetails(@PathVariable("id") String id) {
        return cartService.getCartDetails(UUID.fromString(id));
    }

    @PostMapping("/create")
    public CartDTO createNewCart() {
        return cartService.create();
    }

    @PostMapping("/add-new-item")
    public void addNewItem(@Valid @RequestBody AddNewItemCartDTO dto) {
        cartService.addNewItem(UUID.fromString(dto.getCartId()), UUID.fromString(dto.getProductId()));
    }

    @PostMapping("/update-item")
    public void updateItem(@Valid @RequestBody UpdateItemCartDTO dto) {
        cartService.updateItem(UUID.fromString(dto.getCartId()), UUID.fromString(dto.getProductId()), dto.getQuantity());
    }

    // test
    @GetMapping("/validate-quantity")
    public Boolean validateQuantity(@RequestParam("id") String id, @RequestParam("quantity") Long quantity) {
        return productService.validateQuantity(id, quantity);
    }
}
