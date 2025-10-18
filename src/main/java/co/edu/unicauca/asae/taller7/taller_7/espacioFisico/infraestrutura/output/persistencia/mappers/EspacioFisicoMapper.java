package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EspacioFisicoMapper {
    @Bean
    public ModelMapper crearEspacioFisicoMapper() {
        return new ModelMapper();
    }
}
