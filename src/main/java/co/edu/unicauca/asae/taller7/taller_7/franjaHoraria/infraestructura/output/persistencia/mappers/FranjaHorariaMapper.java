package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FranjaHorariaMapper {
    @Bean
    public ModelMapper crearFranjaHorariaMapper() {
        return new ModelMapper();
    }
}
