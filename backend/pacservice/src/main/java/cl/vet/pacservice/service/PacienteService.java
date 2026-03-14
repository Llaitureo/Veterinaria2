package cl.vet.pacservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.vet.pacservice.client.PacienteClient;
import cl.vet.pacservice.dto.ClienteDTO;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Autowired
    private PacienteClient pacienteClient;

    public PacienteDetalleDTO obtenerPacienteConDueño(Long id) {

        Paciente paciente = pacienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        ClienteDTO dueño = pacienteClient.obtenerCliente(paciente.getClienteId());

        PacienteDetalleDTO detalle = new PacienteDetalleDTO();

        detalle.setNombrePaciente(paciente.getNombre());
        detalle.setEspecie(paciente.getEspecie());
        detalle.setNombreDueño(dueño.getNombre() + " " + dueño.getApellido());
        detalle.setTelefonoDueño(dueño.getTelefono());

        return detalle;
    }
}