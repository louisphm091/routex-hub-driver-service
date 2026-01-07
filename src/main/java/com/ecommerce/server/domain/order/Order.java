package com.ecommerce.server.domain.order;

import com.ecommerce.server.domain.payment.Payment;
import com.ecommerce.server.domain.customer.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import com.ecommerce.server.domain.auth.entities.User;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Bao Pham
 * @created 08/04/2025
 * @project ecom-hub-product-service
 **/

@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id",nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Address address;

    @Column(nullable = false)
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus orderStatus;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = true)
    private String shipmentTrackingNumber;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedDeliveryDate;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderItem> orderItemList;

    private Double discount;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "order",cascade = CascadeType.ALL)
    @ToString.Exclude
    private Payment payment;

}
