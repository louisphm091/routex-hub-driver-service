package com.ecommerce.server.entities;

import com.ecommerce.server.entities.auditing.AbstractAuditingEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.A;
import org.hibernate.engine.spi.CascadeStyle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project lv-shop-server
 **/


@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends AbstractAuditingEntity {
    @Id
    private String productId;
    private String productName;
    private String description;
    private String status;
    private BigDecimal costPrice;
    private BigDecimal sellingPrice;
    private BigDecimal originalPrice;
    private String thumbnail;
    private boolean isVisible;
    private boolean isNewArrival;
    private String slug;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Category> categoryList = new ArrayList<>();

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<ProductVariant> variantList = new ArrayList<>();


    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Resources> resourcesList = new ArrayList<>();

}
