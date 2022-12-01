package fr.mebg.formation.spring.competences.mycomp.competences;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/competences")
public class CompetenceController {
    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    /**
     * FONCTION FINDALL()
     * permet de recuperer la liste des personnes
     * @return une liste de personne
     */
    @GetMapping("")
    public List<Competence> findAll() {
        return competenceService.findAll();
    }

    /**
     *POST
     * fonction recuperant la nouvelle personne à mettre en base de donnée
     * @param entity de type Personne
     * @return une entité
     */
    @PostMapping("")
    public Competence save(@RequestBody Competence entity) {
        return competenceService.save(entity);
    }

    /**
     * FINDBYID
     * fonction permet de trouver par id id
     * @param s qui est l'id de la personne à trouver
     * @return
     */
    @GetMapping("{id}")
    public Competence findById(@PathVariable String s) {
        return competenceService.findById(s);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String s) {
        competenceService.deleteById(s);
    }
}
