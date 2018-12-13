package api;

import api.dto.CartDTO;
import api.entity.CartItem;

public interface CartService {

    CartDTO getCartByUsername(String username);

    void addCartItemToCart(CartItem cartItem, String username);

    void deleteCartItemFromCart(CartItem cartItem, String username);
}
