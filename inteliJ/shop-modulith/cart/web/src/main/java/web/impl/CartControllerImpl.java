package web.impl;

import api.CartService;
import api.dto.CartDTO;
import api.entity.CartItem;
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
        CartDTO cartDTO = cartService.getCartByUsername(principal.getName());

        return null;
    }

    @Override
    public void addCartItemToCart(CartItem cartItem, Principal principal) {
        cartService.addCartItemToCart(cartItem, principal.getName());

    }

    @Override
    public void deleteCartItemFromCart(CartItem cartItem, Principal principal) {
        cartService.deleteCartItemFromCart(cartItem, principal.getName());
    }
}
