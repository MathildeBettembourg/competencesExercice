package fr.mebg.formation.spring.competences.mycomp.personnes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/personnes")
public class PersonneController {
    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    /**
     * FONCTION FINDALL()
     * permet de recuperer la liste des personnes
     * @return une liste de personne
     */
    @GetMapping("")
    public List<Personne> findAll() {
        return personneService.findAll();
    }

    /**
     *POST
     * fonction recuperant la nouvelle personne à mettre en base de donnée
     * @param entity de type Personne
     * @return une entité
     */
    @PostMapping("")
    public Personne save(@RequestBody Personne entity) {
        return personneService.save(entity);
    }

    /**
     * FINDBYID
     * fonction permet de trouver par id id
     * @param id qui est l'id de la personne à trouver
     * @return
     */
    @GetMapping("{id}")
    public Personne findById(@PathVariable String id) {
        return personneService.findById(id);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        personneService.deleteById(id);
    }

    @PutMapping("{id}/competence/{idc}")
    public  NiveauCompetence ajoutModifNiveauCompetence(@PathVariable String id,
                                                @PathVariable String idc,
                                                @RequestParam Integer niveau){
        return this.personneService.modifNiveau(id, idc, niveau);
    }
}
