package entities.resources;

public class ItemCategory {
    private int quantityItem;

    public ItemCategory(int quantityItem) {
        this.quantityItem = quantityItem;
    }

    public int getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(int quantityItem) {
        this.quantityItem = quantityItem;
    }
}
