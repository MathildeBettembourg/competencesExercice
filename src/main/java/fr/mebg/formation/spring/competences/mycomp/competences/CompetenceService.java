package fr.mebg.formation.spring.competences.mycomp.competences;

import java.util.List;

public interface CompetenceService {
    List<Competence> findAll();

    Competence save(Competence entity);

    Competence findById(String s);

    void deleteById(String s);
}
