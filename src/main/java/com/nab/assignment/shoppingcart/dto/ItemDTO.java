package com.nab.assignment.shoppingcart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ItemDTO implements Serializable {
    private UUID id;

    @JsonProperty("product_id")
    private UUID productId;

    private Long quantity;

    @JsonProperty("unit_price")
    private Long unitPrice;
}
