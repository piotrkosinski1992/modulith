package web;

import api.dto.CartDTO;
import api.entity.CartItem;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

public interface CartController {

    @GetMapping("/customer/cart")
    CartDTO getCart(Principal principal);

    @PostMapping("/customer/cart/add")
    void addCartItemToCart(@RequestBody CartItem cartItem, Principal principal);

    @DeleteMapping("/customer/delete/")
    void deleteCartItemFromCart(@RequestBody CartItem cartItem, Principal principal);
}
