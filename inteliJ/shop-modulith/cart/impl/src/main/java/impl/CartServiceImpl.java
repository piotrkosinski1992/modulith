package impl;

import api.CartService;
import api.InventoryService;
import api.ProductService;
import api.dto.CartDTO;
import api.dto.CartItemDTO;
import api.dto.InventoryDTO;
import api.entity.Cart;
import api.entity.CartItem;
import api.entity.Product;
import api.mappers.CartItemMapper;
import api.repository.CartItemRepository;
import api.repository.CartRepository;
import impl.exceptions.NoProductWithIdException;
import impl.exceptions.NotEnoughItemInInventoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private InventoryService inventoryService;

    @Override
    public CartDTO getCartByUsername(String username) {
        Cart cart = cartRepository.findByCustomerUsername(username);

        List<CartItemDTO> cartItemDTOs = cart.getCartItems().stream()
                                               .map(cartItem -> CartItemMapper.mapToCartItemDTO(cartItem))
                                               .collect(Collectors.toList());

        cartItemDTOs.stream().
                forEach(cartItemDTO -> cartItemDTO.
                                setProductPrice(inventoryService.getProductPriceById(cartItemDTO.getProductId())));

        return new CartDTO(calculateTotal(cartItemDTOs),cartItemDTOs);
    }

    @Override
    public void addCartItemToCart(CartItemDTO cartItemDTO, String username) {

        checkProductAvailbilityInInventory(cartItemDTO);

        Cart cart = cartRepository.findByCustomerUsername(username);

        CartItem newOrUpdatedCartItem = null;

        if(itemExistsInCart(cart.getCartItems(), cartItemDTO.getProductId())) {
            for(CartItem cartItem : cart.getCartItems()) {
                if(cartItem.getProduct().getId().equals(cartItemDTO.getProductId())) {
                    cartItem.setAmount(cartItem.getAmount() + cartItemDTO.getAmount());
                    newOrUpdatedCartItem = cartItem;
                    break;
                }
            }
        } else {
            Product product = productService.
                    getProductById(cartItemDTO.getProductId());
            newOrUpdatedCartItem = new CartItem(cart, cartItemDTO.getAmount(),product);
        }

        cartItemRepository.save(newOrUpdatedCartItem);
    }

    private void checkProductAvailbilityInInventory(CartItemDTO cartItemDTO) {
        int productInventoryAmount = inventoryService.getInventoryAmountByProductId(cartItemDTO.getProductId());

        if(productInventoryAmount < cartItemDTO.getAmount()) {
            throw new NotEnoughItemInInventoryException();
        }
    }

    @Override
    @Transactional
    public void deleteCartItem(Long productId, String username) {
        Cart cart = cartRepository.findByCustomerUsername(username);

        cart.getCartItems().removeIf(item -> item.getProduct().getId().equals(productId));

        cartItemRepository.deleteByProductId(productId);
        cartRepository.save(cart);
    }

    private boolean itemExistsInCart(List<CartItem> cartItems, Long productId) {
        return cartItems.stream()
                 .anyMatch(cartItem -> cartItem.getProduct().getId().equals(productId));
    }

    private double calculateTotal(List<CartItemDTO> cartItemDTOs) {
        double total = 0;

        for(CartItemDTO cartItemDTO : cartItemDTOs) {
            InventoryDTO inventory =inventoryService.getInventoryByProductId(cartItemDTO.getProductId());

            total += inventory.getPrice() * cartItemDTO.getAmount();
        }

        return ((double)((int)(total *100.0)))/100.0;
    }

    @Override
    public void updateCartItem(CartItemDTO cartItemDTO, String username) {

        checkProductAvailbilityInInventory(cartItemDTO);

        Cart cart = cartRepository.findByCustomerUsername(username);

        CartItem cartItemToUpdate = cart.getCartItems().stream()
                                                       .filter(item -> item.getProduct().getId().equals(cartItemDTO.getProductId()))
                                                       .findFirst()
                                                       .orElseThrow(() -> new NoProductWithIdException(cartItemDTO.getProductId()));

        cartItemToUpdate.setAmount(cartItemDTO.getAmount());

        cartItemRepository.save(cartItemToUpdate);
    }
}
