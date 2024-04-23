package mec.gov.py.gestionestudiantesuniversitarios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Table(name = "MATRICULA")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Matricula{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @NotNull(message = "El campo persona no puede estar vacío")
    private Persona persona;

    @ManyToOne
    @NotNull(message = "El campo universidad no puede estar vacío")
    private Universidad universidad;
}
