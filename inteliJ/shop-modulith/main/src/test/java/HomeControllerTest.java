import api.dto.CustomerDTO;
import api.repository.CustomerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MainClass.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void clear() {
        if(customerRepository.findByUsername("username123").isPresent()) {
            customerRepository.deleteByUsername("username123");
        }
    }

    @Test
    public void registerShouldSucceedTest() {
        ResponseEntity response = restTemplate
                .postForEntity("/register", new CustomerDTO("username123", "password123", "email@o2.pl" ), CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

/*    @Test
    public void registerShouldFailBecauseWrongEmailFormatTest() {
        ResponseEntity response = restTemplate
                .postForEntity("/register", new CustomerDTO("username123", "password123", "WRONG-EMAIL-FORMAT.pl" ), CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void registerShouldFailBecauseWrongPasswordTest() {
        ResponseEntity response = restTemplate
                .postForEntity("/register", new CustomerDTO("username123", "1", "email@o2.pl" ), CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }*/

}
