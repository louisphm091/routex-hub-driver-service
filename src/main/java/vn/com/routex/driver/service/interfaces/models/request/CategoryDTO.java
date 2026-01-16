package vn.com.routex.driver.service.interfaces.models.request;

import vn.com.routex.driver.service.interfaces.models.CategoryTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project routex-hub-driver-service
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

    private UUID id;
    private String name;
    private String code;
    private String description;
    private List<CategoryTypeDTO> categoryTypes;
}
