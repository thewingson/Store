package kz.almat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilterDTO {

    private String name;
    private String vendor;
    private Integer minPrice;
    private Integer maxPrice;

}
