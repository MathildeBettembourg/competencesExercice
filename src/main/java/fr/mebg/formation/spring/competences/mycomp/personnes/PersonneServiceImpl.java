package fr.mebg.formation.spring.competences.mycomp.personnes;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
//enlever le @servie et faire personne configuration
public class PersonneServiceImpl implements PersonneService {

    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    private final PersonneRepository personneRepository;

    @Override
    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    @Override
    public Personne save(Personne entity) {
        return personneRepository.save(entity);
    }

    @Override
    public Personne findById(String id) {
        return personneRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(String id) {
        personneRepository.deleteById(id);
    }

    public NiveauCompetence modifNiveau(String id,String idc, int niveau){
        NiveauCompetence niveauCompetenceAModifier = this.findById(id).getCompetences().get(idc.parseInt());
        if(niveauCompetenceAModifier == null) {
            niveauCompetenceAModifier.setNiveau(niveau);
            }else if(!niveauCompetenceAModifier.equals(niveau)){
               niveauCompetenceAModifier.setNiveau(niveau);
        }
        return niveauCompetenceAModifier;
    }
}
