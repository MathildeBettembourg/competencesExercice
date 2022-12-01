package fr.mebg.formation.spring.competences.mycomp.equipe;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipeRepository extends MongoRepository<Equipe, String> {
}
