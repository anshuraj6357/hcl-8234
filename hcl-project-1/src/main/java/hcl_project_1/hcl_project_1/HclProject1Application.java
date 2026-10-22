package hcl_project_1.hcl_project_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HclProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(HclProject1Application.class, args)
        ;
	}
}
