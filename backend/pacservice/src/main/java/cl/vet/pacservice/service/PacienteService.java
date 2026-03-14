package cl.vet.pacservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.vet.pacservice.client.ClienteClient;
import cl.vet.pacservice.dto.ClienteDTO;
import cl.vet.pacservice.dto.PacienteDTO;
import cl.vet.pacservice.dto.PacienteDetalleDTO;
import cl.vet.pacservice.model.Paciente;
import cl.vet.pacservice.repository.PacienteRepository;


@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ClienteClient clienteClient;

    public PacienteDetalleDTO obtenerPacienteConDuenio(Long id) {

        Paciente paciente = pacienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        ClienteDTO duenio = clienteClient.obtenerCliente(paciente.getId());

        PacienteDetalleDTO detalle = new PacienteDetalleDTO();

        detalle.setNombre(paciente.getNombre());
        detalle.setEspecie(paciente.getEspecie());
        detalle.setRaza(paciente.getRaza());
        detalle.setEdad(paciente.getEdad());
        detalle.setAntecedentes(paciente.getAntecedentes());
        detalle.setNombreDuenio(duenio.getPrimerNombre() + " " + duenio.getApellidoPaterno());
        detalle.setEnmailDuenio(duenio.getEmail());
        detalle.setTelefonoDuenio(duenio.getTelefono());

        return detalle;
    }

        public List<Paciente> getAllPacientes() {
            return pacienteRepository.findAll();
        }

        public List<PacienteDTO> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll().stream()
                .map(this::convertirAPacienteDTO)
                .collect(Collectors.toList());
    }

    private PacienteDTO convertirAPacienteDTO(Paciente paciente) {

        PacienteDTO pacienteDTO = new PacienteDTO();

        pacienteDTO.setId(paciente.getId());
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setEspecie(paciente.getEspecie());
        pacienteDTO.setRaza(paciente.getRaza());
        pacienteDTO.setFechaNacimiento(paciente.getFechaNacimiento());
        pacienteDTO.setEdad(paciente.getEdad());
        pacienteDTO.setAntecedentes(paciente.getAntecedentes());

        return pacienteDTO;
    }      

    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }



}