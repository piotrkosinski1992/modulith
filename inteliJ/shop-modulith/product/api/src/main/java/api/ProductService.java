package api;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    void deleteProductById(Long productId);

    void updateProduct(Product product);

    List<ProductDTO> getAllProducts();

    List<ProductDTO> getProductsByCategory(Category category);

    ProductDTO getProductById(Long productId);

    void addToCart(ProductCartDTO productCartDTO);

    List<ProductDTO> getProductFromCart(String username);
}
