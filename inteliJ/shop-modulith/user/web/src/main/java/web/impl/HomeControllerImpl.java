package web.impl;

import api.dto.CustomerDTO;
import api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.HomeController;

import javax.validation.Valid;

@RestController
class HomeControllerImpl implements HomeController {

    @Autowired
    private CustomerService customerService;

    @Override
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
