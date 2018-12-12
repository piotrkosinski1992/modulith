package api.entity;

import api.Role;

import javax.persistence.Entity;

@Entity
public class Customer extends User {

    private String email;

    public Customer(String username, String password, String email) {
        super.setRole(Role.CUSTOMER);
        this.email = email;
        super.setUsername(username);
        super.setPassword(password);
    }

    public Customer(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
