package web.impl;

import api.CustomerService;
import api.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import web.CustomerController;

import java.security.Principal;

@RestController
class CustomerControllerImpl implements CustomerController {

    @Autowired
    private CustomerService customerService;

    @Override
    public CustomerDTO getCurrentCustomer(Principal principal) {

        return customerService.getCustomerByUsername(principal.getName());
    }

    @Override
    public ResponseEntity updateCustomer(CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
