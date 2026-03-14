package cl.vet.clienteservice.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "DTO para la creación de un cliente")
public class ClienteDTO {

    public static ClienteDTO dto;

    @Schema(description = "Identificador único para el usuario (Autogenerado).", hidden = true)
    private Long id;
    
    @NotBlank(message = "El primer nombre es obligatorio")
    @Schema(description = "Nombre del cliente")
    private String primerNombre;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Schema(description = "Apellido paterno del cliente")
    private String apellidoPaterno;

    @Schema(description = "Apellido materno del cliente")
    private String apellidoMaterno;
    
    @Email(message = "El email debe ser válido")
    @NotBlank(message = "El email es obligatorio")
    @Schema(description = "Correo de login del cliente", example = "example@gmail.com")
    private String email;

    @NotNull(message = "El teléfono es obligatorio")
    @Positive(message = "El teléfono debe ser un número positivo")
    @Schema(description = "Número de teléfono del cliente", example = "123456789")
    private int telefono;

}