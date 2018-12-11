package api;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO {

    private Long id;

    @NotEmpty(message = "The customer name can't be null.")
    private String username;

    @Size(min = 4, max = 20, message = "Password must have at least 8 signs and can't be bigger that 20 signs")
    private String password;

    public UserDTO(User customer) {
        this.id = customer.getId();
        this.password = customer.getPassword();
        this.username = customer.getUsername();
    }

    public UserDTO(){}

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
