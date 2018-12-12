package web;


import api.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@RequestMapping("/customer")
public interface CustomerController {

    @GetMapping("/get/current")
    CustomerDTO getCurrentCustomer(Principal principal);

    @PutMapping("/update")
    ResponseEntity updateCustomer(@RequestBody @Valid CustomerDTO customerDTO);

}
