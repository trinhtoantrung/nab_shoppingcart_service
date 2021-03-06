package com.nab.assignment.shoppingcart.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "cart")
@DynamicUpdate
public class Cart extends AbstractAuditingEntity {
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

    @OneToOne(mappedBy = "cart")
    private Order order;

    private String userId;

    @OneToMany(mappedBy="cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<>();
}
