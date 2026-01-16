package vn.com.routex.driver.service.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project routex-hub-driver-service
 **/

@Entity
@Table(name = "product_resources")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resources {

    @Id
    private String id;
    private String productId;
    private String name;
    private String resourceType;
    private String url;
    private Boolean isPrimary;
    private String type;
}

