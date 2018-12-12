package web;

import api.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin")
public interface AdminController {

    @GetMapping("/customer/all")
    ResponseEntity<List<CustomerDTO>> getAllCustomers();

    @GetMapping("/customer/username/{username}")
    CustomerDTO getCustomerByUsername(@PathVariable String username);

    @DeleteMapping("/customer/{username}")
    ResponseEntity deleteCustomerByUsername(@PathVariable String username);
}
