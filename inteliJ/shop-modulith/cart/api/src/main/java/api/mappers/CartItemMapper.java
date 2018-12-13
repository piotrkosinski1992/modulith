package api.mappers;

import api.dto.CartItemDTO;
import api.entity.CartItem;

public class CartItemMapper {

    public static CartItemDTO mapToCartItemDTO(CartItem cartItem) {
        return new CartItemDTO(cartItem.getAmount(),cartItem.getProduct().getId(),cartItem.getProduct().getName());
    }
}
