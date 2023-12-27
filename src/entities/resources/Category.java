package entities.resources;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    private String categoryDescription;
    private Double valueCategory;
}
