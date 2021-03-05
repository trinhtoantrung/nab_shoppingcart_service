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
public class NewOrderDTO implements Serializable {
    @NotNull
    @JsonProperty("cart_id")
    private String cartId;

    @JsonProperty("user_id")
    private String userId;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    @JsonProperty("mobile_phone")
    private String mobilePhone;

    @NotNull
    private String email;
}
