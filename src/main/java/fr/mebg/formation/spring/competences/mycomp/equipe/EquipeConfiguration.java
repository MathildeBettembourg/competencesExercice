package fr.mebg.formation.spring.competences.mycomp.equipe;

import fr.mebg.formation.spring.competences.mycomp.personnes.PersonneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class EquipeConfiguration {


    @Bean
    public EquipeService equipeService(EquipeRepository equipeRepository, PersonneService personneService){
        return new EquipeServiceImpl(equipeRepository, personneService);
    }
}
