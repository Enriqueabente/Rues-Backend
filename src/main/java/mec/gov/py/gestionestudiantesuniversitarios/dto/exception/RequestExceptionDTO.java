package mec.gov.py.gestionestudiantesuniversitarios.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.LinkedList;

@AllArgsConstructor
@Getter
public class RequestExceptionDTO {
    private LinkedList<String> description;
}

