import api.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"web", "main","api", "impl"})
@EnableJpaRepositories(basePackages= {"api"})
@ComponentScan(basePackages = {"web", "main","api", "impl", "security"})
@EntityScan(basePackages = {"api"})
public class MainClass {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainClass.class);
    }


}


