package fr.mebg.formation.spring.competences.mycomp.equipe;

import fr.mebg.formation.spring.competences.mycomp.personnes.PersonneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class EquipeConfiguration {

private  static final Logger logger = LoggerFactory.getLogger(EquipeConfiguration.class);
    @Bean
    public EquipeService equipeService(EquipeRepository equipeRepository, PersonneService personneService){
        logger.info("Création du Bean EquipeService");
        return new EquipeServiceImpl(equipeRepository, personneService);
    }
}
