package cl.vet.pacservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import cl.vet.pacservice.dto.ClienteDTO;

@FeignClient(name = "cliente-service", url = "http://localhost:8081")
public interface ClienteClient {
    
    @GetMapping("/api/clientes/{id}") // La ruta exacta.
    ClienteDTO obtenerCliente(@PathVariable("id") Long id);
}