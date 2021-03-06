package com.nab.assignment.shoppingcart.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {
    @Value("${application.services.product-service.url}")
    String PRODUCT_SERVICE_URL;

    @Value(("${application.services.product-service.validate-quantity}"))
    String VALIDATE_QUANTITY;

    @Value(("${application.services.product-service.unit-price}"))
    String UNIT_PRICE;

    private final RestTemplate restTemplate;

    public ProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Boolean validateQuantity(String id, Long quantity) {
        String url = PRODUCT_SERVICE_URL + VALIDATE_QUANTITY + "?id=" + id + "&quantity=" + quantity;
        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);
        return response.getBody();
    }

    @Override
    public Long getUnitPrice(String id) {
        String url = PRODUCT_SERVICE_URL + UNIT_PRICE + "?id=" + id;
        ResponseEntity<Long> response = restTemplate.getForEntity(url, Long.class);
        return response.getBody();
    }
}
