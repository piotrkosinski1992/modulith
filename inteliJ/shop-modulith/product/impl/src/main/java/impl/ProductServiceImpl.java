package impl;

import api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long productId) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public List<ProductDTO> getProductsByCategory(Category category) {
        return null;
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        return null;
    }

    @Override
    public void addToCart(ProductCartDTO productCartDTO) {

    }

    @Override
    public List<ProductDTO> getProductFromCart(String username) {
        return null;
    }
}
