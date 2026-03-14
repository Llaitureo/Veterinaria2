package cl.vet.pacservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cl.vet.pacservice.dto.PacienteDTO;
import cl.vet.pacservice.dto.PacienteDetalleDTO;
import cl.vet.pacservice.model.Paciente;
import cl.vet.pacservice.service.PacienteService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import io.swagger.v3.oas.annotations.media.*;


@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @Operation(summary="Obtencion total" , description="Obtiene todos los elementos de la lista pacientes.")
    @ApiResponses( value = {
        @ApiResponse(responseCode = "200", description = "Objetos de la lista encontrados"),
        @ApiResponse(responseCode = "404", description = "Ningun objeto encontrado.",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "Ejemplo 404.",
                        summary = "Ejemplo de Objeto no encontrado",
                            value = "{}"
                                    )
                                )
                            )
            
                        }
                    )  
    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        return ResponseEntity.ok(pacienteService.getAllPacientes());
    }

    @Operation(summary="Creación de un paciente" , description="Crea un paciente para añadirlo a la lista.")
    @ApiResponses( value= {
        @ApiResponse(responseCode = "200", description = "Objeto creado con éxito.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = PacienteDTO.class),
                    examples = @ExampleObject(name = "EjemploPaciente", 
                        summary = "Ejemplo de paciente válido",
                            value = "{\"nombre\": \"Firulais\",\"especie\": \"Perro\", \"raza\": \"Pastor Alemán\", \"fechaNacimiento\": \"01-09-2019\", \"edad\": 2.0, \"clienteId\": 1, \"antecedentes\": \"N/A - No posee antecedentes.\"}"
                                    )
                                )
                            ),
        @ApiResponse(responseCode = "400", description = "Error de agregación, un campo no posee los requisitos minimos para la creación del usuario/cliente.",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "EjemploPaciente", 
                        summary = "Ejemplo de paciente no válido",
                            value = "{\"nombre\": \"Firulais\",\"especie\": \"Perro\", \"raza\": \"Pastor Alemán\", \"fechaNacimiento\": \"01-09-2019\", \"edad\": 2, \"clienteId\": 1, \"antecedentes\": \"N/A - No posee antecedentes.\"}"
                                    )
                                )
                            )
                        }
                    )
    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.createPaciente(paciente));
    }

    @Operation(summary = "Obtención de detalle según ID", description = "Obtiene una mascota y su dueño según la ID del animal entregada.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Objeto de la lista encontrado."),
        @ApiResponse(responseCode = "404", description = "Objeto no encontrado en la lista.",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "Ejemplo 404.",
                        summary = "Ejemplo de Objeto no encontrado",
                            value = "{}"
                                )
                            )
                        )
                    }
                )
    @GetMapping(value = "/detalle/{id}")
    public ResponseEntity<PacienteDetalleDTO> getDetalleCompletoID(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.obtenerPacienteConDuenio(id));
    }

}