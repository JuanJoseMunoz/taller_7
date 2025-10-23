package co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanMapper {
    @Bean
    public ModelMapper crearBeanMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(org.modelmapper.convention.MatchingStrategies.LOOSE);
        return mapper;
    }
}
