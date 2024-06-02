package mbs.infnet.edu.br.TP3.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StudyMaterial {

    @Id
    private String materialId;

    private String title;
    private String description;

    // getters and setters
}
