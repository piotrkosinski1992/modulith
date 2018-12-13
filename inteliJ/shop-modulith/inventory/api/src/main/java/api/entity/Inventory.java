package api.entity;

import javax.persistence.*;

@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;

    private int amount;

    private double price;

    public Inventory(){}

    public Inventory(Product product, int amount, double price) {
        this.product = product;
        this.amount = amount;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
