package com.ecommerce.server.domain.order;

import com.ecommerce.server.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * @author Bao Pham
 * @created 08/04/2025
 * @project ecom-hub-product-service
 **/

@Entity
@Table(name="order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id",nullable = false)
    @JsonIgnore
    private Product product;

    private UUID productVariantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private Order order;

    @Column(nullable = false)
    private Integer quantity;

    private Double itemPrice;
}
