package api.dto;

public class CartItemDTO {

    private int amount;

    private Long productId;

    private double productPrice;

    private String productName;

    public CartItemDTO(int amount, Long productId, String productName, double productPrice) {
        this.productPrice = productPrice;
        this.amount = amount;
        this.productId = productId;
        this.productName = productName;
    }

    public CartItemDTO() {
    }

    public CartItemDTO(int amount, Long productId, String productName) {
        this.amount = amount;
        this.productId = productId;
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
