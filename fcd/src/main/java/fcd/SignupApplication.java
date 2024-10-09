package fcd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication()
@EnableJpaRepositories(basePackages = "persistence")
@EntityScan(basePackages = "model.commons")
public class SignupApplication {

    public static void main(String[] args) {
        SpringApplication.run(SignupApplication.class, args);
    }

//    @Bean
//    public ISignUpService signUpService() {
//        return new SignUpServiceImpl();
//    }
}
