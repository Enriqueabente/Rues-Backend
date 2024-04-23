package mec.gov.py.gestionestudiantesuniversitarios.repository;

import mec.gov.py.gestionestudiantesuniversitarios.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {}
