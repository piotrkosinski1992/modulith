package api;

import javax.persistence.*;

@Entity
public class ProductCart {

    @Id
    @GeneratedValue
    private Long id;

    private int amount;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductCart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
