package com.ecommerce.server.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project lv-shop-server
 **/
@Entity
@Table(name = "product_variant")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVariant {

    @Id
    private String variantId;
    private String productId;
    private String stockQuantity;
    private String soldQuantity;
    private String status;
    private String size;
    @Lob
    private String attributes;


}

