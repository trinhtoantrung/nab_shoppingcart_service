package com.nab.assignment.shoppingcart.util;

import com.nab.assignment.shoppingcart.dto.CartDTO;
import com.nab.assignment.shoppingcart.dto.ItemDTO;
import com.nab.assignment.shoppingcart.dto.OrderDTO;
import com.nab.assignment.shoppingcart.model.Cart;
import com.nab.assignment.shoppingcart.model.Item;
import com.nab.assignment.shoppingcart.model.Order;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

public class CartUtils {
    public static ItemDTO convertToDTO(Item item) {
        if (item == null) {
            return null;
        }

        ItemDTO dto = new ItemDTO();
        dto.setId(item.getId());
        dto.setProductId(item.getProductId());
        dto.setQuantity(item.getQuantity());
        dto.setUnitPrice(item.getUnitPrice());

        return dto;
    }

    public static CartDTO convertToDTO(Cart cart) {
        if (cart == null) {
            return null;
        }

        CartDTO dto = new CartDTO();

        dto.setId(cart.getId());
        dto.setUserId(cart.getUserId());

        if (CollectionUtils.isNotEmpty(cart.getItems())) {
            Set<ItemDTO> itemDTOSet = cart.getItems().stream().map(item -> convertToDTO(item)).collect(Collectors.toSet());
            dto.setItems(itemDTOSet);
        }

        return dto;
    }

    public static OrderDTO convertToDTO(Order order) {
        if (order == null) {
            return null;
        }

        OrderDTO dto = new OrderDTO();

        dto.setId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setName(order.getName());
        dto.setAddress(order.getAddress());
        dto.setMobilePhone(order.getMobilePhone());
        dto.setEmail(order.getEmail());

        dto.setStatus(order.getStatus());

        dto.setCart(convertToDTO(order.getCart()));

        dto.setCreatedBy(order.getCreatedBy());
        dto.setCreatedDate(order.getCreatedDate());
        dto.setLastModifiedDate(order.getLastModifiedDate());

        return dto;
    }
}
