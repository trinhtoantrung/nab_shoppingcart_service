package com.nab.assignment.shoppingcart.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UpdateItemCartDTO implements Serializable {
    @NotNull
    @JsonProperty("cart_id")
    private String cartId;

    @NotNull
    @JsonProperty("product_id")
    private String productId;

    @NotNull
    private Long quantity;
}
