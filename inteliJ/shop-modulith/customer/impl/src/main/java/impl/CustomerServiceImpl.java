package impl;

import api.UserDTO;
import api.UserRepository;
import api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CustomerServiceImpl implements UserService {

    @Autowired
    private UserRepository customerRepository;

    @Override
    public List<UserDTO> getAllCustomers() {
        return customerRepository.findAll()
                          .stream()
                          .map(user -> new UserDTO(user))
                          .collect(toList());
    }

    @Override
    public UserDTO getCustomerById(Long id) {
        return null;
    }

    @Override
    public UserDTO getCustomerByUsername(String username) {
        return null;
    }

    @Override
    public boolean deleteCustomerByUsername(String username) {
        return false;
    }

    @Override
    public boolean addCustomer(UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean updateCustomer(UserDTO userDTO) {
        return false;
    }
}
