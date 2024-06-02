package mbs.infnet.edu.br.TP3.controller;

import mbs.infnet.edu.br.TP3.entity.StudyMaterial;
import mbs.infnet.edu.br.TP3.service.StudyMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class StudyMaterialController {

    @Autowired
    private StudyMaterialService studyMaterialService;

    @GetMapping
    public List<StudyMaterial> getAllMaterials() {
        return studyMaterialService.getAllMaterials();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyMaterial> getMaterialById(@PathVariable Long id) {
        StudyMaterial material = studyMaterialService.getMaterialById(id);
        if (material != null) {
            return ResponseEntity.ok(material);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public StudyMaterial createMaterial(@RequestBody StudyMaterial studyMaterial) {
        return studyMaterialService.saveMaterial(studyMaterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudyMaterial> updateMaterial(@PathVariable Long id, @RequestBody StudyMaterial updatedMaterial) {
        StudyMaterial material = studyMaterialService.updateMaterial(id, updatedMaterial);
        if (material != null) {
            return ResponseEntity.ok(material);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        studyMaterialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}
