package web.impl;

import api.CartService;
import api.dto.CartDTO;
import api.dto.CartItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import web.CartController;

import java.security.Principal;

@RestController
class CartControllerImpl implements CartController {

    @Autowired
    private CartService cartService;

    @Override
    public CartDTO getCart(Principal principal) {
        return cartService.getCartByUsername(principal.getName());
    }

    @Override
    public void addCartItemToCart(CartItemDTO cartItemDTO, Principal principal) {
        cartService.addCartItemToCart(cartItemDTO, principal.getName());

    }

    @Override
    public void deleteCartItemFromCart(Long productId, Principal principal) {
        cartService.deleteCartItem(productId, principal.getName());
    }

    @Override
    public void updateCartItemFromCart(CartItemDTO cartItemDTO, Principal principal) {
        cartService.updateCartItem(cartItemDTO, principal.getName());
    }
}
