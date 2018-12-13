package web.impl;

import api.ProductCategory;
import api.ProductService;
import api.dto.ProductDTO;
import api.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import web.ProductController;

import java.util.List;

@RestController
class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;

    public void addProduct(Product product) {
        productService.addProduct(product);

    }

    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    public void updateProduct(Product product) {
        productService.updateProduct(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productService.deleteProductById(id);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(ProductCategory category) {
        return productService.getProductsByCategory(category);
    }
}
