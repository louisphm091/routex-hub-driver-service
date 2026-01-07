package com.ecommerce.server.domain.product;

import com.ecommerce.server.domain.auditing.AbstractAuditingEntity;
import com.ecommerce.server.domain.category.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private boolean isNewArrival;
    private String slug;

    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

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
