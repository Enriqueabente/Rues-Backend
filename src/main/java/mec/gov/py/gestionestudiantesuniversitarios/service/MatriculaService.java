package mec.gov.py.gestionestudiantesuniversitarios.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import mec.gov.py.gestionestudiantesuniversitarios.entity.Matricula;
import mec.gov.py.gestionestudiantesuniversitarios.entity.Persona;
import mec.gov.py.gestionestudiantesuniversitarios.entity.Universidad;
import mec.gov.py.gestionestudiantesuniversitarios.repository.MatriculaRepository;
import mec.gov.py.gestionestudiantesuniversitarios.validators.MatriculaValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final MatriculaValidator matriculaValidator;

    /**
     * Guardar
     */
    @Transactional
    public Matricula save(Matricula matricula) {
        matriculaValidator.validateNuevaMatricula(matricula);
        return matriculaRepository.save(matricula);
    }

    /**
     * Obtener all
     */
    public List<Matricula> fetchAll() {
        return matriculaRepository.findAll();
    }

    /**
     * Actualizar
     */
    @Transactional
    public Matricula update(Long id, Matricula matricula) {

        matriculaValidator.validateNuevaMatricula(matricula);

        Matricula matriculaExistente = matriculaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));

        matriculaExistente.setPersona(matricula.getPersona());
        matriculaExistente.setUniversidad(matricula.getUniversidad());

        return matriculaRepository.save(matriculaExistente);
    }

    /**
     * Eliminar
     */
    public ResponseEntity<String> delete(Long id) {
        matriculaRepository.deleteById(id);
        return ResponseEntity.ok("Matrícula eliminada satisfactoriamente de la base de datos");
    }

    /**
     * Obtener por Id
     */
    public Matricula getById(Long id){

        Optional<Matricula> matricula= matriculaRepository.findById(id);

        if (matricula.isPresent()) {
            return matricula.get();
        } else {
            throw new EntityNotFoundException("No se encontró la matrícula");
        }

    }

    /**
     * Obtener por persona y universidad
     */
    public List<Matricula> findByPersonaAndUniversidad(Long personaCedula, Long universidadId){
        final Persona persona = new Persona();
        final Universidad universidad = new Universidad();

        persona.setCedula(personaCedula);
        universidad.setId(universidadId);

        return matriculaRepository.findByPersonaAndUniversidad(persona, universidad);
    }

    /**
     * Obtener por persona
     */
    public List<Matricula> findByPersona(Long personaCedula){

        final Persona persona = new Persona();
        persona.setCedula(personaCedula);

        return matriculaRepository.findByPersona(persona);
    }

    /**
     * Obtener por universidad
     */
    public List<Matricula> findByUniversidad(Long universidadId){

        final Universidad universidad = new Universidad();
        universidad.setId(universidadId);

        return matriculaRepository.findByUniversidad(universidad);
    }
}