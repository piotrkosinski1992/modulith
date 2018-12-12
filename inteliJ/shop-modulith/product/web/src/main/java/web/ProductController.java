package web;

import api.Product;
import api.ProductDTO;
import api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/admin/product")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);

    }

    @GetMapping("/customer/product/all")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
}
