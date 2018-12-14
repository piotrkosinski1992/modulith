package api;

import api.dto.ProductDTO;
import api.entity.Product;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    void deleteProductById(Long productId);

    void updateProduct(Product product);

    List<ProductDTO> getAllProducts();

    List<ProductDTO> getProductsByCategory(ProductCategory productCategory);

    ProductDTO getProductDTOById(Long productId);

    Product getProductById(Long productId);

}
