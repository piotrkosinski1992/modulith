package api;

import api.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO getCustomerByUsername(String username);

    void deleteCustomerByUsername(String username);

    void addCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerDTO customerDTO);
}
