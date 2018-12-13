package web;

import api.ProductCategory;
import api.dto.ProductDTO;
import api.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductController {

    @PostMapping("/admin/product")
    void addProduct(@RequestBody Product product);

    @GetMapping("/customer/product/all")
    List<ProductDTO> getAllProducts();

    @PostMapping("/admin/update")
    void updateProduct(@RequestBody Product product);

    @DeleteMapping("/admin/delete/{id}")
    void deleteProductById(@PathVariable Long id);

    @GetMapping("/customer/product/{category}")
    List<ProductDTO> getProductsByCategory(@PathVariable ProductCategory category);
}
