package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller7.taller_7.comons.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.casosDeUso.GestionarEspacioFisicoCUAdapter;

@Configuration
public class BeanConfigurations {
    
    @Bean
    public GestionarEspacioFisicoCUAdapter crearGestionarEspacioFisicoCUInt(
            GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway,
            FormateadorResultadosIntPort objEspacioFisicoFormateadorResultados) {
                GestionarEspacioFisicoCUAdapter objGestionarEspacioFisicoCU = new GestionarEspacioFisicoCUAdapter(objGestionarEspacioFisicoGateway,
                objEspacioFisicoFormateadorResultados);
        return objGestionarEspacioFisicoCU;
    }
    
}