package cl.vet.pacservice.dto;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "nombre", "especie", "raza", "edad", "antecedentes", "nombreDuenio", "telefonoDuenio", "enmailDuenio" })
public class PacienteDetalleDTO {
    private String nombre;
    private String especie;
    private String raza;
    private BigDecimal edad;
    private String antecedentes;
    
    private String nombreDuenio; // Estos datos vienen del otro microservicio
    private String enmailDuenio;
    private Integer telefonoDuenio;

}