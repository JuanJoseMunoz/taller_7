package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller7.taller_7.comons.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.output.GestionarDocenteGetwayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.casosDeUso.GestionarDocenteCUAdapter;

@Configuration
public class BeanDocenteConfigurations {
    
    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(
            GestionarDocenteGetwayIntPort objGestionarDocenteGateway,
            FormateadorResultadosIntPort objDocenteFormateadorResultados) {
                GestionarDocenteCUAdapter objGestionarDocenteCU = new GestionarDocenteCUAdapter(objGestionarDocenteGateway,
                objDocenteFormateadorResultados);
        return objGestionarDocenteCU;
    }
}
