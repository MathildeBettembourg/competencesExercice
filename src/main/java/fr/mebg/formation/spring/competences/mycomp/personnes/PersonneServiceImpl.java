package fr.mebg.formation.spring.competences.mycomp.personnes;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class PersonneServiceImpl {

    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    private final PersonneRepository personneRepository;

    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    public Personne save(Personne entity) {
        return personneRepository.save(entity);
    }

    public Personne findById(String s) {
        return personneRepository.findById(s).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(String s) {
        personneRepository.deleteById(s);
    }
}
