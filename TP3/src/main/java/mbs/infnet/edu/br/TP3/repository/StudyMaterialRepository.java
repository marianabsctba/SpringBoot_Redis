package mbs.infnet.edu.br.TP3.repository;


import mbs.infnet.edu.br.TP3.entity.StudyMaterial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudyMaterialRepository extends MongoRepository<StudyMaterial, String> {
}
