package fr.mebg.formation.spring.competences.mycomp.personnes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Personne {

    @Id
    private String id;
    private String nom;
    private String prenom;

    private List<NiveauCompetence> competences=new ArrayList<>();


}
