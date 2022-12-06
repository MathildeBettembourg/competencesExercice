package fr.mebg.formation.spring.competences.mycomp.equipe;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/equipes")
public class EquipeController {
    private final EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    /**
     * FONCTION FINDALL()
     * permet de recuperer la liste des personnes
     * @return une liste de personne
     */
    @GetMapping("")
    public List<Equipe> findAll() {
        return equipeService.findAll();
    }

    /**
     *POST
     * fonction recuperant la nouvelle personne à mettre en base de donnée
     * @param entity de type Personne
     * @return une entité
     */
    @PostMapping("")
    public Equipe save(@RequestBody Equipe entity) {
        return equipeService.save(entity);
    }

    /**
     * FINDBYID
     * fonction permet de trouver par id id
     * @param s qui est l'id de la personne à trouver
     * @return
     */
    @GetMapping("{id}")
    public Equipe findById(@PathVariable String s) {
        return equipeService.findById(s);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String s) {
        equipeService.deleteById(s);
    }
    @PutMapping("{idEquipe}/membres/{idMembre}")
    public Equipe ajoutMembre(@PathVariable String idEquipe,
                              @PathVariable String idMembre){
        return this.equipeService.ajoutMembre(idEquipe, idMembre);
    }
    @DeleteMapping("{idEquipe}/membres/{idMembre}")
    public Equipe deleteMembre(@PathVariable String idEquipe,
                              @PathVariable String idMembre){
        return this.equipeService.deleteMembre(idEquipe, idMembre);
    }

   // @GetMapping("{idEquipe}/membres?fields={id, nom, prenom, maxcomp}")
}
