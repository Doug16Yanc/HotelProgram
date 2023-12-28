package entities.resources;

public class Item {
    private String itemDescription;

    public Item(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
