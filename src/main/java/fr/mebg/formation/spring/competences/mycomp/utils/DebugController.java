package fr.mebg.formation.spring.competences.mycomp.utils;

import fr.mebg.formation.spring.competences.mycomp.competences.Competence;
import fr.mebg.formation.spring.competences.mycomp.competences.CompetenceRepository;
import fr.mebg.formation.spring.competences.mycomp.equipe.EquipeRepository;
import fr.mebg.formation.spring.competences.mycomp.personnes.PersonneRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("debug")
@Profile("dev")
public class DebugController {
    //ici peut faire cça car outils
    private final CompetenceRepository competenceRepository;
    private final PersonneRepository personneRepository;
    private final EquipeRepository equipeRepository;

    public DebugController(CompetenceRepository competenceRepository, PersonneRepository personneRepository, EquipeRepository equipeRepository) {
        this.competenceRepository = competenceRepository;
        this.personneRepository = personneRepository;
        this.equipeRepository = equipeRepository;
    }

    @DeleteMapping("clear")
    public void clear(){
        competenceRepository.deleteAll();
        personneRepository.deleteAll();
        equipeRepository.deleteAll();
    }
    @PostMapping("init")
    public void init(){
        clear();
        this.competenceRepository.save(new Competence("JAVA", "Un langage de programmation"));
    }
}
