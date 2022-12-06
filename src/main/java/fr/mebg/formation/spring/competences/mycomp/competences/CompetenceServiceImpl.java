package fr.mebg.formation.spring.competences.mycomp.competences;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

public class CompetenceServiceImpl implements CompetenceService {


    public CompetenceServiceImpl(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

    private final CompetenceRepository competenceRepository;

    @Override
    public List<Competence> findAll() {
        return competenceRepository.findAll();
    }

    @Override
    public Competence save(Competence entity) {
        entity.setDateModification(LocalDateTime.now());
        return competenceRepository.save(entity);
    }

    @Override
    public Competence findById(String id) {
        return competenceRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(String id) {
        competenceRepository.deleteById(id);
    }
}
