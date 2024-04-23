package mec.gov.py.gestionestudiantesuniversitarios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "UNIVERSIDAD")
@Data
public class Universidad {
    @Id
    @NotNull(message = "El campo id no puede estar vacío")
    private Long id;

    @NotEmpty(message = "El campo nombre no puede estar vacío")
    private String nombre;

}
