package com.nab.assignment.shoppingcart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nab.assignment.shoppingcart.model.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CartDTO implements Serializable {
    private UUID id;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("is_order")
    private Boolean isOrder = false;
    private Set<Item> items;
}
