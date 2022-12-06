package fr.mebg.formation.spring.competences.mycomp.personnes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mebg.formation.spring.competences.mycomp.competences.Competence;
import fr.mebg.formation.spring.competences.mycomp.competences.CompetenceService;
import fr.mebg.formation.spring.competences.mycomp.personnes.dto.PersonneMinimalDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//enlever le @servie et faire personne configuration
public class PersonneServiceImpl implements PersonneService {
    private final ObjectMapper objectMapper;
    private final PersonneRepository personneRepository;
    private final CompetenceService competenceService;

    public PersonneServiceImpl(PersonneRepository personneRepository, ObjectMapper objectMapper, CompetenceService competenceService) {
        this.personneRepository = personneRepository;
        this.objectMapper = objectMapper;
        this.competenceService = competenceService;
    }


    @Override
    public List<PersonneMinimalDTO> findAll() {
//        List<Personne> listPersonnes = personneRepository.findAll();
//        return objectMapper.convertValue(
//                listPersonnes,
//                new TypeReference<List<PersonneMinimalDTO>>() {
//                };
        //ou bien**************************************************
        List<Personne> listPersonnes = personneRepository.findAll(PageRequest.of(0, 10)).toList();
        return objectMapper.convertValue(
                listPersonnes,
                new TypeReference<List<PersonneMinimalDTO>>() {
                }
        );
        //ou bien*******************************************************

        // List<PersonneMinimalDTO> listePersonneMinimal = new ArrayList<>();
        // for (Personne personne : listPersonnes) {
//            PersonneMinimalDTO personneMinimal = new PersonneMinimalDTO();
//            personneMinimal.setNom(personne.getNom());
//            personneMinimal.setPrenom(personne.getPrenom());
//            personneMinimal.setId(personne.getId());
//            listePersonneMinimal.add(personneMinimal);

        //instance qui contient vers la classe template
        //   listePersonneMinimal.add(this.objectMapper.convertValue(personne, PersonneMinimalDTO.class));
        // }
        //return listePersonneMinimal;
//OU BIEN ************************************************************
        //demande 1e pàag ou retour 10 elements.
        //ca retourne une page et pas une liste
//        List<Personne> listePersonnes = personneRepository.findAll(PageRequest.of(0, 10));
//        return objectMapper.convertValue(
//                listPersonnes,
//                new TypeReference<List<PersonneMinimalDTO>>() {
//                }
//        );
    }

    @Override
    public Personne save(Personne entity) {
        entity.setDateModification(LocalDateTime.now());
        return personneRepository.save(entity);
    }

    @Override
    public Personne findById(String id) {
        return personneRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(String id) {
        personneRepository.deleteById(id);
    }

    @Override
    public Personne modifNiveau(String id, String idc, Integer niveau) {
        Personne personne = filtreListeNiveauCompetenceParCompetencee(id, idc);
        personne.getCompetences().add(new NiveauCompetence((new Competence(idc)), niveau));
        //creer le constructeur avec l'id
        return this.save(personne);}

//        Personne personne = this.findById(id);
//        List<NiveauCompetence> niveauCompetenceAModifier = personne.getCompetences();
//        Boolean flag = false;
//        for (NiveauCompetence competence : niveauCompetenceAModifier
//        ) {
//            if
//            (Objects.equals(idc, competence.getCompetence().getId())) {
//                competence.setNiveau(niveau);
//                flag = true;
//            }
//        }
//        if (!flag) {
//            niveauCompetenceAModifier.add(new NiveauCompetence(this.competenceService.findById(idc), niveau));
//        }
//        return this.save(personne);
//    }


//     public Personne modifNiveau(String id, String idc, Integer niveau) {




    @Override
    public Personne supprimerCompetence(String id, String idc) {
        Personne personne = this.findById(id);
        List<NiveauCompetence> listeNiveauCompetenceAModifier = personne.getCompetences();
        for (NiveauCompetence competence : listeNiveauCompetenceAModifier
        ) {
            if
            (!Objects.equals(idc, competence.getCompetence().getId())) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            } else {
                competence.setNiveau(0);
            }
        }
        personne.setDateModification(LocalDateTime.now());
        return this.save(personne);
    }

    ;

    //public Personne supprimerNiveauCompetence(String id, String idc){
    //Personne personne = filtreListeNiveauCompetenceParCompetencee(id, idc)
    //return this.save(personne);

    public Personne filtreListeNiveauCompetenceParCompetencee(String id, String idc) {
         Personne personne = this.findById(id);
        Competence competence=this.competenceService.findById(idc);
        List<NiveauCompetence>niveauCompetences = personne.getCompetences();
        niveauCompetences.removeIf(niveauCompetence -> niveauCompetence.getCompetence()==null || niveauCompetence.getCompetence().equals(competence));
        return this.save(personne);
    }

    @Override
    public List<Personne> afficherCompetencesValeurs(String idc, Integer niveaux) {
        List<Personne> listePersonnes = this.personneRepository.findAll();
        List<Personne> selectedPersonnes = new ArrayList<>();
        for (Personne personne : listePersonnes
        ) {
            for (NiveauCompetence listeNiveauCompetence : personne.getCompetences())
                if (Objects.equals(idc, listeNiveauCompetence.getCompetence().getId()) && listeNiveauCompetence.getNiveau() >= niveaux) {
                    selectedPersonnes.add(personne);
                }
        }
        return selectedPersonnes;

    }


    ;
    @Override
    public List<Personne> afficherNiveauSupA(String idc, Integer niveaux) {
        List<Personne> personnes = this.personneRepository.findByCompetencesCompetenceId(idc);

        return personnes.stream().filter(personne -> {
            return personne.getCompetences().stream().anyMatch(niveauCompetence -> {
                return niveauCompetence.getCompetence().getId().equals(idc)
                        && niveauCompetence.getNiveau() >= niveaux;
            });
        }).toList();
    }
}



