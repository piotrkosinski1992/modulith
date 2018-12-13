package api.dto;

public class InventoryDTO {

    private Long productId;

    private String productName;

    private int amount;

    private double price;

    public InventoryDTO(Long productId, String productName, int amount, double price) {
        this.productId = productId;
        this.productName = productName;
        this.amount = amount;
        this.price = price;
    }

    public InventoryDTO() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
