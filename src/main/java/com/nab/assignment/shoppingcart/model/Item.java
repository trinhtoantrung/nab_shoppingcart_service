package com.nab.assignment.shoppingcart.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "item")
@DynamicUpdate
public class Item extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.StandardRandomStrategy"
                    )
            }
    )
    @Column(name = "id")
    private UUID id;

    @Column(name = "product_id")
    private UUID productId;

    private Long quantity = 1L;

    @Column(name = "unit_price")
    private Long unitPrice;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;

    public Item(UUID productId, Long unitPrice, Cart cart) {
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.cart = cart;
    }
}
