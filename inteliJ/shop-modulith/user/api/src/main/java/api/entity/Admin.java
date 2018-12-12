package api.entity;

import api.Role;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    public Admin(){}

    public Admin(String username, String password) {
        super.setUsername(username);
        super.setPassword(password);
        super.setRole(Role.ADMIN);
    }
}
