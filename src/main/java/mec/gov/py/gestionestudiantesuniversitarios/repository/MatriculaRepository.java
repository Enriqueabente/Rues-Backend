package mec.gov.py.gestionestudiantesuniversitarios.repository;

import mec.gov.py.gestionestudiantesuniversitarios.entity.Matricula;
import mec.gov.py.gestionestudiantesuniversitarios.entity.Persona;
import mec.gov.py.gestionestudiantesuniversitarios.entity.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    List<Matricula> findByPersonaAndUniversidad(Persona persona, Universidad universidad);

    List<Matricula> findByPersona(Persona persona);

    List<Matricula> findByUniversidad(Universidad universidad);
}
