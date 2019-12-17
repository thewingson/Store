package kz.almat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilterDTO {

    private String name;
    private List<Long> vendor;
    private Long category;
    private Integer minPrice;
    private Integer maxPrice;

}
