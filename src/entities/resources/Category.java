package entities.resources;

public class Category {
    private String categoryDescription;
    private Double valueCategory;

    public Category(String categoryDescription, Double valueCategory) {
        this.categoryDescription = categoryDescription;
        this.valueCategory = valueCategory;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
    public Double getValueCategory() {
        return valueCategory;
    }
    public void setValueCategory(Double valueCategory) {
        this.valueCategory = valueCategory;
    }
}
