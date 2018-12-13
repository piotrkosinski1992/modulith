package impl;

import api.*;
import api.dto.ProductDTO;
import api.entity.Product;
import api.mapper.ProductMapper;
import api.repository.ProductRepository;
import impl.execptions.NoProductWithIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
        productRepository.deleteById(productId);
    }

    @Override
    @Transactional
    public void updateProduct(Product updatedProduct) {
        Product product = productRepository.findById(updatedProduct.getId())
                .orElseThrow(() -> new NoProductWithIdException(updatedProduct.getId()));

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setProductCategory(updatedProduct.getProductCategory());

    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                       .map(product -> ProductMapper.mapToProductDTO(product))
                       .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByCategory(ProductCategory productCategory) {
        List<Product> products = productRepository.findByProductCategory(productCategory);

        return products.stream()
                .map(product -> ProductMapper.mapToProductDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NoProductWithIdException(productId));

        return ProductMapper.mapToProductDTO(product);
    }

}
