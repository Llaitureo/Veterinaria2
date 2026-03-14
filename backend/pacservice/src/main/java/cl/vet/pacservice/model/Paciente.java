package cl.vet.pacservice.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pacientes")
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "La especie es obligatoria")
    @Column(name = "especie", nullable = false, length = 50)
    private String especie;

    @NotBlank(message = "La raza es obligatoria")
    @Column(name = "raza", nullable = false, length = 50)
    private String raza;

    @NotBlank(message = "La fecha de nacimiento es obligatoria")
    @NotNull(message = "No se aceptan nulos en esta casilla")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @PastOrPresent(message = "La fecha de nacimiento no puede ser una fecha futura")
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @NotNull(message = "No se aceptan nulos en esta casilla")
    @Positive(message = "La edad del paciente debe ser positiva")
    @Column(name = "edad", nullable = false)
    private BigDecimal edad;

    @NotBlank(message = "Los antecedentes del paciente no pueden estar en blanco")
    @NotNull(message = "No se aceptan nulos en esta casilla")
    @Column(name = "antecedentes", nullable = false, length = 450)
    private String antecedentes;

}