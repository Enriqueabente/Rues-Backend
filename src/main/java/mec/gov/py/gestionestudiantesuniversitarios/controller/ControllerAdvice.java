package mec.gov.py.gestionestudiantesuniversitarios.controller;

import mec.gov.py.gestionestudiantesuniversitarios.dto.exception.RequestExceptionDTO;
import mec.gov.py.gestionestudiantesuniversitarios.exception.MatriculaInvalidaException;
import mec.gov.py.gestionestudiantesuniversitarios.exception.RequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exceptions handlers de las excepciones personalizadas
 */
@RestControllerAdvice
public class ControllerAdvice {

    /**
     * Para errores en el request
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RequestExceptionDTO> requestExceptionHandler(MethodArgumentNotValidException ex) {

        RequestException error = new RequestException(ex.getFieldErrors());

        return ResponseEntity.badRequest().body(new RequestExceptionDTO(error.getDescription()));
    }

    /**
     * Para errores al trabajar con una matrícula
     */
    @ExceptionHandler(MatriculaInvalidaException.class)
    public ResponseEntity<String> matriculaInvalidaExceptionHandler(MatriculaInvalidaException ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
