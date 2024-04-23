package mec.gov.py.gestionestudiantesuniversitarios.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import mec.gov.py.gestionestudiantesuniversitarios.entity.Universidad;
import mec.gov.py.gestionestudiantesuniversitarios.repository.UniversidadRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UniversidadService {

    private final UniversidadRepository universidadRepository;

    /**
     * Guardar un Universidad
     */
    @Transactional
    public Universidad save(Universidad universidad) {
        return universidadRepository.save(universidad);
    }

    /**
     * Obtener todos los Personas
     */
    public List<Universidad> fetchAll() {
        return universidadRepository.findAll();
    }

    /**
     * Actualizar una Universidad
     */
    public Universidad update(Long identificador, Universidad universidad) {

        Universidad universidadExistente = universidadRepository.findById(identificador)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(identificador)));

        universidadExistente.setNombre(universidad.getNombre());

        return universidadRepository.save(universidadExistente);
    }

    /**
     * Eliminar Universidad
     */
    public ResponseEntity<String> delete(Long universidad) {
        universidadRepository.deleteById(universidad);
        return ResponseEntity.ok("Universidad eliminada satisfactoriamente de la base de datos");
    }

    /**
     * Obtener Universidad por cedula
     */
    public Universidad getById(Long identificador){

        Optional<Universidad> universidad = universidadRepository.findById(identificador);

        if (universidad.isPresent()) {
            return universidad.get();
        } else {
            throw new EntityNotFoundException("No se encontró la Universidad");
        }

    }
}