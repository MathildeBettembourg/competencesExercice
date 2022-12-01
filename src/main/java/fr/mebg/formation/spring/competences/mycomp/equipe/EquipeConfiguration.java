package fr.mebg.formation.spring.competences.mycomp.equipe;

import fr.mebg.formation.spring.competences.mycomp.personnes.PersonneRepository;
import fr.mebg.formation.spring.competences.mycomp.personnes.PersonneService;
import fr.mebg.formation.spring.competences.mycomp.personnes.PersonneServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class equieConfigurationp {


    @Bean
    public EquipeService equipeService(EquipeRepository equipeRepository){
        return new EquipeServiceImpl(equipeRepository);
    }
}
