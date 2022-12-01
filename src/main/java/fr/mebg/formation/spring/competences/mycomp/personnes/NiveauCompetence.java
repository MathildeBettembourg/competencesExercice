package fr.mebg.formation.spring.competences.mycomp.personnes;

import fr.mebg.formation.spring.competences.mycomp.competences.Competence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NiveauCompetence {
    @DBRef
    private Competence competence;
    private Integer niveau;
}
