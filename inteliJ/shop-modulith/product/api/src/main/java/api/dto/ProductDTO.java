package api.dto;

import api.ProductCategory;
import api.entity.Product;

public class ProductDTO {

    private Long id;

    private String name;

    private ProductCategory productCategory;

    public ProductDTO(){}

    public ProductDTO(Long id, String name, ProductCategory productCategory){
        this.id = id;
        this.name = name;
        this.productCategory = productCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

}
