package fr.mebg.formation.spring.competences.mycomp.competences;

import fr.mebg.formation.spring.competences.mycomp.utils.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
//@AllArgsConstructor
@NoArgsConstructor
public class Competence extends Entity {

//      a enlever car vient d'entity  @Id
//        private String id;

        private String nom;
        private String description;

    public Competence(String id) {
        this.id = id;
    }

    public Competence(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }
}


