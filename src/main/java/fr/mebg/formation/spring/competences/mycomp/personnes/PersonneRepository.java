package fr.mebg.formation.spring.competences.mycomp.personnes;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonneRepository extends MongoRepository<Personne, String> {
List<Personne> findByCompetencesCompetenceId(String competenceId);
}
