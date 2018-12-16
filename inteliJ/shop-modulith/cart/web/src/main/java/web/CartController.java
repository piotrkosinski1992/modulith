package web;

import api.dto.CartDTO;
import api.dto.CartItemDTO;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

public interface CartController {

    @GetMapping("/customer/cart")
    CartDTO getCart(Principal principal);

    @PostMapping("/customer/cart/add")
    void addCartItemToCart(@RequestBody CartItemDTO cartItemDTO, Principal principal);

    @DeleteMapping("/customer/delete/{productId}")
    void deleteCartItemFromCart(@PathVariable Long productId, Principal principal);

    @PutMapping("/customer/update")
    void updateCartItemFromCart(@RequestBody CartItemDTO cartItemDTO, Principal principal);
}
