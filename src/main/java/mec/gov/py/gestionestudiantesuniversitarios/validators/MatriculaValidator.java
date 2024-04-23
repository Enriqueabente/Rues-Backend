package mec.gov.py.gestionestudiantesuniversitarios.validators;

import lombok.AllArgsConstructor;
import mec.gov.py.gestionestudiantesuniversitarios.entity.Matricula;
import mec.gov.py.gestionestudiantesuniversitarios.entity.Persona;
import mec.gov.py.gestionestudiantesuniversitarios.exception.MatriculaInvalidaException;
import mec.gov.py.gestionestudiantesuniversitarios.service.PersonaService;
import org.springframework.stereotype.Component;

/**
 * Validaciones con respecto a las matrículas
 */
@Component
@AllArgsConstructor
public class MatriculaValidator {

    final PersonaService personaService;

    /**
     * Para validar una matrícula nueva en el sistema
     * @param matricula La matrícula nueva a validar
     */
    public void validateNuevaMatricula(Matricula matricula){

        // obtener datos de la persona
        final Persona persona = personaService.getByCedula(matricula.getPersona().getCedula());

        // validar si ha terminado el colegio
        if(Boolean.FALSE.equals(persona.getTerminoColegio())){
            throw new MatriculaInvalidaException("La persona no ha terminado el colegio");
        }

        // validar si no tiene antecedentes
        if(Boolean.TRUE.equals(persona.getTieneAntecedentes())){
            throw new MatriculaInvalidaException("La persona tiene antecedentes");
        }
    }
}
