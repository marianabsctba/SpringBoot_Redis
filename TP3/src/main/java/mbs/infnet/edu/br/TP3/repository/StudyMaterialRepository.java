package mbs.infnet.edu.br.TP3.repository;

import mbs.infnet.edu.br.TP3.entity.StudyMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyMaterialRepository extends JpaRepository<StudyMaterial, Long> {
}
