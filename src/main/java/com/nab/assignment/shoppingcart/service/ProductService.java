package com.nab.assignment.shoppingcart.service;

public interface ProductService {
    Boolean validateQuantity(String id, Long quantity);
    Long getUnitPrice(String id);
}
