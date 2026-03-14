package cl.vet.pacservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PacserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacserviceApplication.class, args);
	}

}
