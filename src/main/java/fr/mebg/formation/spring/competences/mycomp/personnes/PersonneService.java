package fr.mebg.formation.spring.competences.mycomp.personnes;

import java.util.List;

public interface PersonneService {
    List<Personne> findAll();

    Personne save(Personne entity);

    Personne findById(String s);

    void deleteById(String s);
}
