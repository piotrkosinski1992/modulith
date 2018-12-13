package api.mapper;

import api.dto.ProductDTO;
import api.entity.Product;

public class ProductMapper {

    public static Product mapToProduct(ProductDTO productDTO) {
        return new Product(productDTO.getId(),productDTO.getName(), productDTO.getProductCategory());
    }

    public static ProductDTO mapToProductDTO(Product product) {
        return new ProductDTO(product.getId(),product.getName(), product.getProductCategory());
    }
}
