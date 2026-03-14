package cl.vet.pacservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PacienteserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacienteserviceApplication.class, args);
	}

}
