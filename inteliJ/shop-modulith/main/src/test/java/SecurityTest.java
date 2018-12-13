import api.dto.CustomerDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MainClass.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void loginAdminPageWithCustomerCredShouldFailTest() {
        ResponseEntity response = restTemplate.withBasicAuth("user","user")
                .getForEntity("/admin/dummy/path", CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
    }

    @Test
    public void loginAdminPageWithAdminCredShouldPassTest() {
        ResponseEntity response = restTemplate.withBasicAuth("admin","admin")
                .getForEntity("/admin/dummy/path", CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void loginAdminPageWithoutCredShouldFailTest() {
        ResponseEntity response = restTemplate
                .getForEntity("/admin/dummy/path", CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }


    @Test
    public void loginCustomerPageWithCustomerCredShouldPassTest() {
        ResponseEntity response = restTemplate.withBasicAuth("user","user")
                .getForEntity("/customer/dummy/path", CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void loginCustomerPageWithAdminCredShouldPassTest() {
        ResponseEntity response = restTemplate.withBasicAuth("admin","admin")
                .getForEntity("/customer/dummy/path", CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void loginCustomerPageWithoutCredShouldFailTest() {
        ResponseEntity response = restTemplate
                .getForEntity("/customer/dummy/path", CustomerDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }



}
