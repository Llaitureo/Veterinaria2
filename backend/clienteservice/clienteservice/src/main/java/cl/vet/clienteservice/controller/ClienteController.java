package cl.vet.clienteservice.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.vet.clienteservice.model.Cliente;
import cl.vet.clienteservice.repository.ClienteRepository;
import cl.vet.clienteservice.dto.ClienteDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.MediaTypes;


@FeignClient(name = "cliente-service", url = "http://localhost:8081")
@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Operation(summary="Obtencion total" , description="Obtiene todos los elementos de la lista cliente.")
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
    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    
    @Operation(summary="Creación de un cliente" , description="Crea un cliente para añadirlo a la lista.")
    @ApiResponses( value= {
        @ApiResponse(responseCode = "200", description = "Objeto creado con éxito.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ClienteDTO.class),
                    examples = @ExampleObject(name = "EjemploCliente", 
                        summary = "Ejemplo de cliente válido",
                            value = "{\"primerNombre\": \"Fernanda\",\"apellidoPaterno\": \"Llaitureo\", \"apellidoMaterno\": \"Nallar\", \"email\": \"apa.pant@gmail.com\", \"telefono\": \"123456789\"}"
                                    )
                                )
                            ),
        @ApiResponse(responseCode = "400", description = "Error de agregación, un campo no posee los requisitos minimos para la creación del usuario/cliente.",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "EjemploCliente", 
                        summary = "Ejemplo de cliente válido",
                            value = "{\"primerNombre\": \"Fernanda\",\"apellidoPaterno\": \"Llaitureo\", \"apellidoMaterno\": \"Nallar\", \"email\": \"apa.pant@gmail.com\", \"telefono\": \"123456789\"}"
                                )
                            )
                        )
        }
    )
    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Operation(summary = "Obtención de usuarios según ID", description = "Obtiene un usuario según la ID entregada.")
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
    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE, value = "/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
