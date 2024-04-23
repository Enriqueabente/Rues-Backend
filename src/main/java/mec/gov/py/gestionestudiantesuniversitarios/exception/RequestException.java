package mec.gov.py.gestionestudiantesuniversitarios.exception;

import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.LinkedList;
import java.util.List;

/**
 * Para cuando se produzcan errores en el request, como por ejemplo que se hayan recibido datos inválidos
 */
@Getter
public class RequestException extends RuntimeException {
    private final LinkedList<String> description;

    public RequestException(List<FieldError> errorsList) {
        this.description = new LinkedList<>();
        setErrors(errorsList);
    }

    private void setErrors(List<FieldError> errors){
        // Obtener los campos que dieron error
        errors.forEach(err ->
                appendDescription(err.getDefaultMessage())
        );
    }

    /**
     * Agregar una descripción a la excepción. Se pueden agregar varias descripciones llamando varias veces a la función
     * @param descripcion La descripción a agregar
     */
    public void appendDescription(String descripcion) {
        this.description.add(descripcion);
    }

}
