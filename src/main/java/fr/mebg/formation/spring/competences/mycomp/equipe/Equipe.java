package fr.mebg.formation.spring.competences.mycomp.equipe;

import fr.mebg.formation.spring.competences.mycomp.personnes.Personne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {

        @Id
        private String id;

        private String nom;
        @DBRef
        private List<Personne> membres = new ArrayList<>();

        //***************autre solution delete personne dans une liste
        //set est une liste sans doublons
        private Set<Personne> membresSet = new HashSet<>();
        @Override
        public boolean equals(Object other) {
                if (this == other) return true;
                if (other == null || getClass() != other.getClass()) return false;
                Equipe equipe = (Equipe) other;
                //id, this.id() autre est celui de l'equipe
                return Objects.equals(id, equipe.id) ;
        }

}


