package fr.mebg.formation.spring.competences.mycomp.personnes.dto;

import fr.mebg.formation.spring.competences.mycomp.competences.Competence;
import fr.mebg.formation.spring.competences.mycomp.personnes.NiveauCompetence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonneCompetenceMaximumDTO {
    private  String id;
    private String nom;
    private String prenom;
    private NiveauCompetence competenceMaximum;
}
