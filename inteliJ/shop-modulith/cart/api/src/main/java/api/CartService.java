package api;

import api.dto.CartDTO;
import api.dto.CartItemDTO;
import api.entity.Cart;

public interface CartService {

    CartDTO getCartByUsername(String username);

    void addCartItemToCart(CartItemDTO cartItem, String username);

    void deleteCartItem(CartItemDTO cartItem, String username);

    void updateCartItem(CartItemDTO cartItem, String username);
}
