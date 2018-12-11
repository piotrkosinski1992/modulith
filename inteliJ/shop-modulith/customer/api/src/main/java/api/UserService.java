package api;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllCustomers();

    UserDTO getCustomerById(Long id);

    UserDTO getCustomerByUsername(String username);

    boolean deleteCustomerByUsername(String username);

    boolean addCustomer(UserDTO userDTO);

    boolean updateCustomer(UserDTO userDTO);
}
