package com.nab.assignment.shoppingcart.model;

import com.nab.assignment.shoppingcart.constant.OrderStatus;
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
@Entity(name = "nab_order")
@DynamicUpdate
public class Order extends AbstractAuditingEntity{
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

    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    @Column(name = "user_id")
    private String userId;
    private String name;
    private String address;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    private String email;

    private OrderStatus status = OrderStatus.WAITING;
}
