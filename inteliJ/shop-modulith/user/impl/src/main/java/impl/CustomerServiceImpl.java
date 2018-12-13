package impl;

import api.*;
import api.dto.CustomerDTO;
import api.entity.Cart;
import api.entity.Customer;
import api.mapper.CustomerMapper;
import api.repository.CartRepository;
import api.repository.CustomerRepository;
import impl.exceptions.NoCustomerWithIdException;
import impl.exceptions.NoCustomerWithUsernameException;
import impl.exceptions.NotUniqueEmailException;
import impl.exceptions.NotUniqueUnsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                                 .stream()
                                 .map(customer -> CustomerMapper.mapToCustomerDTO(customer))
                                 .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer  = customerRepository.findById(id).orElseThrow(() -> new NoCustomerWithIdException(id));

        return CustomerMapper.mapToCustomerDTO(customer);
    }

    @Override
    public CustomerDTO getCustomerByUsername(String username) {
        Customer customer = customerRepository.findByUsername(username).orElseThrow(() -> new NoCustomerWithUsernameException(username));

        return CustomerMapper.mapToCustomerDTO(customer);
    }

    @Override
    public void deleteCustomerByUsername(String username) {
        customerRepository.deleteByUsername(username);

    }

    @Override
    public void addCustomer(CustomerDTO customerDTO) {

        if(customerRepository.findByEmail(customerDTO.getEmail()).isPresent()) {
            throw new NotUniqueEmailException(customerDTO.getEmail());
        }
        if(customerRepository.findByUsername(customerDTO.getUsername()).isPresent()) {
            throw new NotUniqueUnsernameException(customerDTO.getUsername());
        }
        customerDTO.setPassword(passwordEncoder.encode(customerDTO.getPassword()));

        cartRepository.save(new Cart(CustomerMapper.mapToCustomer(customerDTO)));
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {

        Customer customer = customerRepository.findByUsername(customerDTO.getUsername())
                        .orElseThrow(() -> new NoCustomerWithUsernameException(customerDTO.getUsername()));

        if(!customerDTO.getEmail().equals(customer.getEmail())) {
            customerRepository.findByEmail(customerDTO.getEmail()).ifPresent( result ->  {
                throw new NotUniqueEmailException(customerDTO.getEmail());
            });
        }

        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));

        //TODO verify if needed
        customerRepository.save(customer);

    }
}
