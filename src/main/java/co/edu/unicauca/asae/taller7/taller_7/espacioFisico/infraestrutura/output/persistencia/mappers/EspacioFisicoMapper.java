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
    /* 
    private ModelMapper espacioFisicoMapper;
    
    public EspacioFisicoMapper(ModelMapper espacioFisicoMapper) {
        this.espacioFisicoMapper = espacioFisicoMapper;
    }
    
    public EspacioFisico mapearDeEntityAEspacioFisico(EspacioFisicoEntity objEspacioFisicoEntity) {
        return this.espacioFisicoMapper.map(objEspacioFisicoEntity, EspacioFisico.class);
    }
    
    public EspacioFisicoEntity mapearDeEspacioFisicoAEntity(EspacioFisico objEspacioFisico) {
        return this.espacioFisicoMapper.map(objEspacioFisico, EspacioFisicoEntity.class);
    }
    
    public List<EspacioFisico> mapearDeEntityAEspacioFisico(List<EspacioFisicoEntity> listaEspaciosFisicosEntity) {
        return this.espacioFisicoMapper.map(listaEspaciosFisicosEntity, new TypeToken<List<EspacioFisico>>() {}.getType());
    }
    */
}