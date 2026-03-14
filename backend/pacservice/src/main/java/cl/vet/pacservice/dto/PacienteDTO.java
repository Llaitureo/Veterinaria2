package cl.vet.pacservice.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data   
@Schema(description = "DTO para la creación de un paciente")    
public class PacienteDTO {
    
    public static PacienteDTO pDto;

    @Schema(description = "Identificador único para el usuario (Autogenerado).", hidden = true)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Schema(description = "Nombre del animal")
    private String nombre;

    @NotBlank(message = "La especie es obligatoria")
    @Schema(description = "Nombre de la especie")
    private String especie;

    @NotBlank(message = "El tipo de raza es obligatorio")
    @Schema(description = "Raza del animal")
    private String raza;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @PastOrPresent(message = "La fecha de nacimiento no puede ser una fecha futura")
    @Schema(description = "Fecha de nacimiento del paciente", example = "22-09-2005")
    private LocalDate fechaNacimiento;

    @NotNull(message = "No se aceptan nulos en esta casilla")
    @Positive(message = "La edad del paciente debe ser positiva")
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "200.00")
    @Digits(integer = 5, fraction = 2, message = "Maximo 3 enteros y 2 decimales")
    @Schema(description = "Edad del paciente", example = "3.0, 0.7, 12.3 y 12.0")
    private Double edad;

    @NotBlank(message = "Los antecedentes del paciente no pueden estar en blanco")
    @NotNull(message = "No se aceptan nulos en esta casilla")
    @Schema(description = "Descripción de los antecendentes del paciente", example = "N/A - No posee antecedentes.")
    private String antecedentes;
}