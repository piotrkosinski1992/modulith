package api.mapper;

import api.dto.CustomerDTO;
import api.entity.Customer;

public class CustomerMapper {

    public static Customer mapToCustomer(CustomerDTO customerDTO) {
        return new Customer(customerDTO.getUsername(), customerDTO.getPassword(), customerDTO.getEmail());
    }

    public static CustomerDTO mapToCustomerDTO(Customer customer) {
        return new CustomerDTO(customer.getUsername(), customer.getPassword(), customer.getEmail());
    }


}
