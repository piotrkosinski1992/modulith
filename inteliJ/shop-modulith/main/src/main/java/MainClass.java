import api.entity.Cart;
import api.repository.CartRepository;
import api.entity.Admin;
import api.repository.AdminRepository;
import api.entity.Customer;
import api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"web", "main","api", "impl"})
@EnableJpaRepositories(basePackages= {"api"})
@ComponentScan(basePackages = {"web", "main","api", "impl", "security"})
@EntityScan(basePackages = {"api"})
public class MainClass implements CommandLineRunner {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CartRepository cartRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainClass.class);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {


        adminRepository.save(new Admin("admin", passwordEncoder.encode("admin")));

        cartRepository.save(new Cart(new Customer("user", passwordEncoder.encode("user"),"malpa@o2.pl")));
    }
}


