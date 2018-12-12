package api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CustomerDTO {

    @NotEmpty(message = "email is mandatory field")
    @Email(message = "invalid email")
    private String email;

    @NotEmpty(message = "The customer name can't be null.")
    private String username;

    @NotEmpty(message = "password is mandatory")
    @Size(min = 4, max = 20, message = "Password must have at least 8 signs and can't be bigger that 20 signs")
    private String password;

    public CustomerDTO(String username, String password, String email) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public CustomerDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
