package com.ecommerce.server.domain.category;

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
@Table(name="categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    private String categoryId;
    private String categoryName;
    private String categoryTypeId;
}
