package cl.vet.clienteservice.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El primer nombre es obligatorio")
    @Column(name = "primer_nombre", nullable = false, length = 50)
    private String primerNombre;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Column(name = "apellido_paterno", nullable = false, length = 50)
    private String apellidoPaterno;

    @NotBlank(message = "El apellido materno es obligatorio")
    @Column(name = "apellido_materno", nullable = false, length = 50)
    private String apellidoMaterno;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico debe ser válido")
    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @NotNull(message = "El teléfono es obligatorio")
    @Column(nullable = false, length = 15)
    @Positive(message = "El teléfono debe ser un número positivo")
    private int telefono;
    
}
