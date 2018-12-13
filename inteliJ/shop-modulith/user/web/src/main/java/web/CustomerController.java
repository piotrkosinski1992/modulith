package web;


import api.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RequestMapping("/customer")
public interface CustomerController {

    @GetMapping("/get/current")
    ResponseEntity<CustomerDTO> getCurrentCustomer(Principal principal);

    @PostMapping("/update")
    ResponseEntity updateCustomer(@RequestBody @Valid CustomerDTO customerDTO);

}
