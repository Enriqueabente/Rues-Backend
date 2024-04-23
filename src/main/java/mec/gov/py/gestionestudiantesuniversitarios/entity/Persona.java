package mec.gov.py.gestionestudiantesuniversitarios.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "PERSONA")
@Data
public class Persona {

    @Id
    @NotNull(message = "El campo cedula no puede estar vacío")
    private Long cedula;

    @NotEmpty(message = "El campo nombre no puede estar vacío")
    private String nombre;

    @NotEmpty(message = "El campo apellido no puede estar vacío")
    private String apellido;

    @NotNull(message = "El campo apellido no puede estar vacío")
    private Boolean terminoColegio;

    @NotNull(message = "El campo apellido no puede estar vacío")
    private Boolean tieneAntecedentes;

}
