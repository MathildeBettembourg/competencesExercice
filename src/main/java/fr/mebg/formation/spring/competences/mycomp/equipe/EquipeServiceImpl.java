package fr.mebg.formation.spring.competences.mycomp.equipe;

import fr.mebg.formation.spring.competences.mycomp.personnes.Personne;
import fr.mebg.formation.spring.competences.mycomp.personnes.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class EquipeServiceImpl implements EquipeService {
    private final EquipeRepository equipeRepository;
    private final PersonneService personneService;

    public EquipeServiceImpl(EquipeRepository equipeRepository, PersonneService personneService) {
        this.equipeRepository = equipeRepository;
        this.personneService = personneService;
    }


    @Override
    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }
// ajour de personne sevice, mise a jours du constructor
    //verif,
    @Override
    public Equipe save(Equipe entity) {
        for(Personne membre:entity.getMembres()){
            if(membre.getId() == null){
                this.personneService.save(membre);
        }
    }
        return equipeRepository.save(entity);
    }

    @Override
    public Equipe findById(String id) {
        return equipeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(String id) {
        equipeRepository.deleteById(id);
    }

    /**
     * Ajoute un membre {idMembre} à équipe [idEquipe}
     *
     * @param idEquipe idEquipe de l'équipe
     * @param idMembre idMembre de la personne qui devient membre
     * @return
     */
    @Override
    public Equipe ajoutMembre(String idEquipe, String idMembre) {
        Equipe equipe=this.findById(idEquipe);
        Personne membre = this.personneService.findById(idMembre);
        equipe.getMembres().add(membre);
        //transforme en objet stream ou a fonction anymatch qui return un bool si match ou pas
        if(equipe.getMembres().stream().noneMatch(equipeMembre->equipeMembre.getId().equals(idMembre))){
            equipe.getMembres().add(membre);
        }
        //<=> different
//        boolean isMembre = false;
//        for(Personne equipeMembre: equipe.getMembres()){
//            if(equipeMembre.getId().equals(idMembre)){
//                isMembre=true;
//                break;
//            }
//        }
//        if (!isMembre) equipe.getMembres().add(membre);


               return this.save(equipe);
    }

    @Override
    public Equipe deleteMembre(String idEquipe, String idMembre) {
        Equipe equipe=this.findById(idEquipe);
        equipe.getMembres().removeIf(membre->membre.getId().equals(idMembre));
        return save(equipe);
//        Personne membreToDelete = this.personneService.findById(idMembre);
//        if(equipe.getMembres().stream().anyMatch(equipeMembre->equipeMembre.getId().equals(idMembre))){
//            equipe.getMembres().remove(membreToDelete);
//            }
        //<->**********************
//        boolean toDeleteMembre = false;
//        for(Personne equipeMembre: equipe.getMembres()){
//            if(equipeMembre.getId().equals(idMembre)){
//                toDeleteMembre=true;
//                equipe.getMembres().remove(membreToDelete);
            }



        //******avec rewrite du equal
}
