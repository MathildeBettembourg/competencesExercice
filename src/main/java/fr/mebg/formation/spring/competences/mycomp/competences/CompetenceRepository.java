package fr.mebg.formation.spring.competences.mycomp.competences;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetenceRepository extends MongoRepository<Competence, String> {
}
