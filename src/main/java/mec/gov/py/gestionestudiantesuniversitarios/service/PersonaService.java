package mec.gov.py.gestionestudiantesuniversitarios.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import mec.gov.py.gestionestudiantesuniversitarios.entity.Persona;
import mec.gov.py.gestionestudiantesuniversitarios.repository.PersonaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;

    /**
     * Guardar un Persona
     */
    @Transactional
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    /**
     * Obtener todos los Personas
     */
    public List<Persona> fetchAll() {
        return personaRepository.findAll();
    }

    /**
     * Actualizar una persona
     */
    public Persona update(Long cedula, Persona persona) {

        Persona personaExistente = personaRepository.findById(cedula)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(cedula)));

        personaExistente.setNombre(persona.getNombre());
        personaExistente.setApellido(persona.getApellido());
        personaExistente.setTieneAntecedentes(persona.getTieneAntecedentes());
        personaExistente.setTerminoColegio(persona.getTerminoColegio());

        return personaRepository.save(personaExistente);
    }

    /**
     * Eliminar persona
     */
    public ResponseEntity<String> delete(Long cedula) {
        personaRepository.deleteById(cedula);
        return ResponseEntity.ok("Persona eliminada satisfactoriamente de la base de datos");
    }

    /**
     * Obtener persona por cedula
     */
    public Persona getByCedula(Long cedula){

        Optional<Persona> persona = personaRepository.findById(cedula);

        if (persona.isPresent()) {
            return persona.get();
        } else {
            throw new EntityNotFoundException("No se encontró la persona");
        }

    }
}