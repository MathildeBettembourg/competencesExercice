package fr.mebg.formation.spring.competences.mycomp.equipe;

import fr.mebg.formation.spring.competences.mycomp.personnes.Personne;
import fr.mebg.formation.spring.competences.mycomp.personnes.dto.PersonneCompetenceMaximumDTO;

import java.util.List;

public interface EquipeService {


        List<Equipe> findAll();

        Equipe save(Equipe entity);

        Equipe findById(String s);

        void deleteById(String s);

    /**
     * Ajoute un membre {idMembre} à équipe [idEquipe}
     * @param idEquipe idEquipe de l'équipe
     * @param idMembre idMembre de la personne qui devient membre
     * @return
     */
        Equipe ajoutMembre(String idEquipe, String idMembre);
        Equipe deleteMembre(String idEquipe, String IdMembre);

        List<PersonneCompetenceMaximumDTO> trouverPersonneCompetenceMaximum(String idEquipe);
    }


