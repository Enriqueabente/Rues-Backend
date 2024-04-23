package mec.gov.py.gestionestudiantesuniversitarios.repository;

import mec.gov.py.gestionestudiantesuniversitarios.entity.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Long> {}
