package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocenteMapper {
    @Bean
    public ModelMapper docenteMapper() {
        return new ModelMapper();
    }
}
