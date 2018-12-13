import api.dto.CustomerDTO;
import api.entity.Customer;
import api.repository.CustomerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MainClass.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void init() {
        if(!customerRepository.findByUsername("username123").isPresent()) {
            customerRepository.save(new Customer("username123", passwordEncoder.encode("password123"),"email@o2.pl"));
        }
        if(!customerRepository.findByUsername("username234").isPresent()) {
            customerRepository.save(new Customer("username234", passwordEncoder.encode("password234"),"2email@o2.pl"));
        }
    }

    @After
    public void clear() {
        if(customerRepository.findByUsername("username123").isPresent()) {
            customerRepository.deleteByUsername("username123");
        }
        if(customerRepository.findByUsername("username234").isPresent()) {
            customerRepository.deleteByUsername("username234");
        }
    }


    @Test
    @Transactional
    public void getCurrentCustomerWithCustomerCredShouldPassTest() {
        ResponseEntity<CustomerDTO> response = restTemplate.withBasicAuth("user", "user")
                .getForEntity("/customer/get/current", CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getUsername()).isEqualTo("user");
    }

    @Test
    @Transactional
    public void getCurrentCustomerWithoutCustomerCredShouldFailTest() {
        ResponseEntity<CustomerDTO> response = restTemplate
                .getForEntity("/customer/get/current", CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

/*    @Test
    public void updateCustomerEmailShouldPassTest() {
        ResponseEntity response = restTemplate.withBasicAuth("username123", "password123")
                .postForEntity("/customer/update",
                        new CustomerDTO("username234", passwordEncoder.encode("password234"),"updatedEmail@o2.pl"), CustomerDTO.class);

        assertThat(customerRepository.findByUsername("username234").get().getEmail()).isEqualTo("updatedEmail@o2.pl");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }*/

/*    @Test
    public void updateWithEmailThatExistsInDBShouldFailTest() {

        ResponseEntity response = restTemplate.withBasicAuth("username123", "password123")
                .exchange("/customer/update", HttpMethod.PUT,
                        new HttpEntity<>(new CustomerDTO("username123", passwordEncoder.encode("password123"),"32email@o2.pl")), CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }*/

}
