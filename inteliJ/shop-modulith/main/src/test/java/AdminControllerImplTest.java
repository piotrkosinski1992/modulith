import api.dto.CustomerDTO;
import api.entity.Customer;
import api.repository.CustomerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MainClass.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdminControllerImplTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void init() {
        if(!customerRepository.findByUsername("username123").isPresent()) {
            customerRepository.save(new Customer("username123","password123","email@o2.pl"));
        }
    }

    @After
    public void clear() {
        if(customerRepository.findByUsername("username123").isPresent()) {
            customerRepository.deleteByUsername("username123");
        }
    }

    @Test
    @Transactional
    public void getAllCustomersFromDBTest() {
        ResponseEntity<List<CustomerDTO>> response =  restTemplate.withBasicAuth("admin","admin")
                .exchange("/admin/customer/all",  HttpMethod.GET,
                        null, new ParameterizedTypeReference<List<CustomerDTO>>(){});

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(1);
    }

    @Test
    @Transactional
    public void getCustomerByUsernameTest() {
        ResponseEntity<CustomerDTO> response = restTemplate.withBasicAuth("admin","admin")
                .getForEntity("/admin/customer/username/user", CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getUsername()).isEqualTo("user");
    }

    @Test
    public void deleteCustomerByUsernameTest() {
        restTemplate.withBasicAuth("admin","admin")
                .delete("/admin/customer/username123");

        assertThat(customerRepository.findByUsername("username123").isPresent()).isFalse();
    }
}
