package com.nab.assignment.shoppingcart.constant;

public enum OrderStatus {
    WAITING(100),
    PROCESSING(200),
    DELIVERING(300),
    DELIVERED(400),
    CANCELED(500);

    private Integer code;

    OrderStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
