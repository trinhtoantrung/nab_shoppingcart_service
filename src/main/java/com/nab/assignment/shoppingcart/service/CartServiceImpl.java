package com.nab.assignment.shoppingcart.service;

import com.nab.assignment.shoppingcart.dto.CartDTO;
import com.nab.assignment.shoppingcart.model.Cart;
import com.nab.assignment.shoppingcart.model.Item;
import com.nab.assignment.shoppingcart.repository.CartRepository;
import com.nab.assignment.shoppingcart.util.CartUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    private static final Logger log = LoggerFactory.getLogger(CartServiceImpl.class);

    private final CartRepository cartRepository;
    private final ProductService productService;

    public CartServiceImpl(CartRepository cartRepository, ProductService productService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

    @Override
    public CartDTO getCartDetails(UUID id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        return optionalCart.isPresent() ? CartUtils.convertToDTO(optionalCart.get()) : null;
    }

    @Override
    public CartDTO create() {
        Cart newCart = new Cart();
        newCart = cartRepository.save(newCart);

        return CartUtils.convertToDTO(newCart);
    }

    @Transactional
    @Override
    public void addNewItem(UUID cartId, UUID productId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (!optionalCart.isPresent()) {
            log.error("Not found cart_id: " + cartId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found cart_id: " + cartId);
        }
        Cart cart = optionalCart.get();

        Item isExistedItem = findItemInSet(cart.getItems(), productId);

        // call product service to check product quantity
        Boolean isValidProduct = productService.validateQuantity(productId.toString(), isExistedItem == null ? 1L : isExistedItem.getQuantity() + 1);
        if (!isValidProduct) {
            log.error("product_id: " + productId.toString() + " out of stock");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "product_id: " + productId.toString() + " out of stock");
        }

        // call product service to get price
        Long unitPrice = productService.getUnitPrice(productId.toString());

        // add product (quantity, price) to cart
        if (isExistedItem == null) {
            log.debug("Add new item {} to cart {}", productId, cartId);

            Item newItem = new Item(productId, unitPrice, cart);
            cart.getItems().add(newItem);
        } else {
            log.debug("Update +1 item 's quantity {} to cart {}", productId, cartId);
            isExistedItem.setQuantity(isExistedItem.getQuantity() + 1);
            isExistedItem.setUnitPrice(unitPrice);
        }

        cartRepository.save(cart);
    }

    @Override
    public void updateItem(UUID cartId, UUID productId, Long quantity) {
    }

    private Item findItemInSet(Set<Item> itemSet, UUID id) {
        for (Item item: itemSet) {
            if (item.getProductId().equals(id)) {
                return item;
            }
        }

        log.debug("Not found product_id: {} in item set", id);
        return null;
    }
}
