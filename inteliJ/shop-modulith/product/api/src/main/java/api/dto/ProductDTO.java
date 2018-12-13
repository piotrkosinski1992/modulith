package api.dto;

import api.ProductCategory;
import api.entity.Product;

public class ProductDTO {

    private Long id;

    private String name;

    private ProductCategory productCategory;

    private String description;

    public ProductDTO(){}

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.productCategory = product.getProductCategory();
        this.description = product.getDescription();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
