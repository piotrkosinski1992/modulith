package impl;

import api.CartService;
import api.dto.CartDTO;
import api.entity.Cart;
import api.entity.CartItem;
import api.repository.CartRepository;
import api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public CartDTO getCartByUsername(String username) {
        Cart cart = cartRepository.findByCustomerUsername(username);

        return null;
    }

    @Override
    public void addCartItemToCart(CartItem cartItem, String username) {
        Cart cart = cartRepository.findByCustomerUsername(username);

        if(itemExistsInCart(cart.getCartItems(), cartItem.getProduct().getId())) {
//            cart.getCartItems()
//                .stream()
//                .filter(item -> item.getProduct().getId() == productId)
//                    .findFirst()
//                    .map(item -> item.setAmount(item.getAmount() + cartItem.getAmount()))
                    //5 min rozkminy czy potrzebuje cart i wywalam cart
        }


        cartRepository.save(cart);
    }

    @Override
    public void deleteCartItemFromCart(CartItem cartItem, String username) {

    }

    private boolean itemExistsInCart(List<CartItem> cartItems, Long productId) {
        return cartItems.stream()
                 .filter(cartItem -> cartItem.getProduct().getId() == productId)
                 .findFirst()
                 .isPresent();


    }
}
