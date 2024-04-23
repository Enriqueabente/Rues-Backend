package mec.gov.py.gestionestudiantesuniversitarios.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Para cuando se tenga una matrícula inválida
 */
@AllArgsConstructor
@Getter @Setter
public class MatriculaInvalidaException extends RuntimeException {
    private final String message;
}
