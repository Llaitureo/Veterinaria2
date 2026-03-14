package cl.vet.clienteservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.vet.clienteservice.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Puedes agregar métodos personalizados de consulta aquí si es necesario
}
