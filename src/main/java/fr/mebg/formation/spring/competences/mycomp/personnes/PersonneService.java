package fr.mebg.formation.spring.competences.mycomp.personnes;

import fr.mebg.formation.spring.competences.mycomp.personnes.dto.PersonneMinimalDTO;

import java.net.NetworkInterface;
import java.util.List;

public interface PersonneService {
    List<PersonneMinimalDTO> findAll();

    Personne save(Personne entity);

    Personne findById(String s);

    void deleteById(String s);

    /**
     * Ajoute un niveau de comptence a la personne,
     * ce a une personne;
     * si cette personne possede deja un niveau de
     * competence sa valeur de niveau est mise a jours.
     * @param id id personne
     * @param idc id du niveau de competence
     * @param niveau a editer
     * @return personne
     */
   Personne modifNiveau(String id, String idc, Integer niveau);

    /**
     * Methode pour suppreimer ici nullifier le niveau de competence d'une personne
     * @param id de la personne
     * @param idc de la competence à delete
     * @return la personne modifiee
     */
   Personne supprimerCompetence(String id, String idc);

    /**
     * Retourne une liste de personne par competence
     * @param idc de la competence
     * @param niveaux niveau de la competence
     * @return
     */
    List<Personne> afficherCompetencesValeurs(String idc, Integer niveaux);
    List<Personne> afficherNiveauSupA(String idc, Integer niveaux);
}
