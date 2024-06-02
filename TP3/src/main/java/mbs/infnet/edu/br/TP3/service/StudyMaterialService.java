package mbs.infnet.edu.br.TP3.service;

import mbs.infnet.edu.br.TP3.entity.StudyMaterial;
import mbs.infnet.edu.br.TP3.repository.StudyMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyMaterialService {

    @Autowired
    private StudyMaterialRepository studyMaterialRepository;

    public List<StudyMaterial> getAllMaterials() {
        return studyMaterialRepository.findAll();
    }

    public StudyMaterial getMaterialById(Long id) {
        return studyMaterialRepository.findById(id).orElse(null);
    }

    public StudyMaterial saveMaterial(StudyMaterial studyMaterial) {
        return studyMaterialRepository.save(studyMaterial);
    }

    public StudyMaterial updateMaterial(Long id, StudyMaterial updatedMaterial) {
        if (studyMaterialRepository.existsById(id)) {
            updatedMaterial.setId(id);
            return studyMaterialRepository.save(updatedMaterial);
        }
        return null;
    }

    public void deleteMaterial(Long id) {
        studyMaterialRepository.deleteById(id);
    }
}
