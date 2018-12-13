package api.repository;

import api.ProductCategory;
import api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByProductCategory(ProductCategory productCategory);
}
