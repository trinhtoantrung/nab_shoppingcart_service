package com.nab.assignment.shoppingcart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nab.assignment.shoppingcart.constant.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO implements Serializable {
    private UUID id;

    private CartDTO cart;
    private OrderStatus status;

    @JsonProperty("user_id")
    private String userId;
    private String name;
    private String address;

    @JsonProperty("mobile_phone")
    private String mobilePhone;
}
