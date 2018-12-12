package web.impl;

import api.CustomerService;
import api.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import web.AdminController;

import java.util.List;

@RestController
public class AdminControllerImpl implements AdminController {

    @Autowired
    private CustomerService customerService;

    @Override
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {

        List<CustomerDTO> customers = customerService.getAllCustomers();

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @Override
    public CustomerDTO getCustomerByUsername(String username) {
        return customerService.getCustomerByUsername(username);
    }

    @Override
    public ResponseEntity deleteCustomerByUsername(String username) {
        customerService.deleteCustomerByUsername(username);

        return new ResponseEntity(HttpStatus.OK);
    }
}
