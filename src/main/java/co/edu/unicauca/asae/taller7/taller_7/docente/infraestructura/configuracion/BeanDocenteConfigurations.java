package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller7.taller_7.comons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.casosDeUso.GestionarDocenteCUAdapter;

@Configuration
public class BeanDocenteConfigurations {
    
    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(
            GestionarDocenteGatewayIntPort objGestionarDocenteGateway,
            FormateadorResultadosIntPort objDocenteFormateadorResultados) {
                GestionarDocenteCUAdapter objGestionarDocenteCU = new GestionarDocenteCUAdapter(objGestionarDocenteGateway,
                objDocenteFormateadorResultados);
        return objGestionarDocenteCU;
    }
}
