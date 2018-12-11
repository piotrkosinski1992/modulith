package web;


import api.UserDTO;
import api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    private UserService customerService;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return customerService.getAllCustomers();
    }
}
