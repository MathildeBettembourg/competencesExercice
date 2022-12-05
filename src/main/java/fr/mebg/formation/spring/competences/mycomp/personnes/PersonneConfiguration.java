package fr.mebg.formation.spring.competences.mycomp.personnes;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mebg.formation.spring.competences.mycomp.competences.CompetenceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonneConfiguration {
    @Bean
    public PersonneService personneService(PersonneRepository personneRepository, ObjectMapper objectMapper, CompetenceService competenceService){
        return new PersonneServiceImpl(personneRepository, objectMapper, competenceService);
    }
}
