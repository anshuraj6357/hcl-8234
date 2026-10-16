package module2.cunstructorDi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Adress address() {
        return new Adress();
    }

    @Bean
    public Employee employee(Adress address) {
        return new Employee(address);
    }
}