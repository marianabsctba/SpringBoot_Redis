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

    public List<StudyMaterial> getAllStudyMaterials() {
        return studyMaterialRepository.findAll();
    }

    public StudyMaterial saveStudyMaterial(StudyMaterial studyMaterial) {
        return studyMaterialRepository.save(studyMaterial);
    }

    public StudyMaterial getStudyMaterialById(String materialId) {
        return studyMaterialRepository.findById(materialId).orElse(null);
    }

    public void deleteStudyMaterialById(String materialId) {
        studyMaterialRepository.deleteById(materialId);
    }
}
