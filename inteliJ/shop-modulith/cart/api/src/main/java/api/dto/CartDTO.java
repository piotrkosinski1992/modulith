package api.dto;

import java.util.List;

public class CartDTO {

    private double total;

    private List<CartItemDTO> cartItems;

    public CartDTO() {
    }

    public CartDTO(double total, List<CartItemDTO> cartItems) {
        this.total = total;
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }
}
