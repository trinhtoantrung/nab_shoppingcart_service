package com.nab.assignment.shoppingcart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nab.assignment.shoppingcart.constant.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
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
    private String email;

    @JsonProperty("mobile_phone")
    private String mobilePhone;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("last_modified_date")
    private LocalDateTime lastModifiedDate;
}
