package com.nab.assignment.shoppingcart.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nab.assignment.shoppingcart.constant.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ProcessOrderDTO implements Serializable {
    @NotNull
    private String id;

    @NotNull
    private OrderStatus status;

    @JsonProperty("is_paid")
    private Boolean isPaid = false;
}
