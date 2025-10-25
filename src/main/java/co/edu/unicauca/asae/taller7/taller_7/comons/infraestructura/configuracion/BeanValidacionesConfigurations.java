package co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.repositories.DocenteRepositoryInt;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.repositorios.EspacioFisicoRepositoryInt;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.ValidacionesGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena.Orquestadorvalidaciones;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.gateway.ValidacionesFranjaHorariaGatewayImplAdapter;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios.CursoRepositoryInt;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios.FranjaHorariaRepositoryInt;

@Configuration
public class BeanValidacionesConfigurations {
    @Bean
    public ValidacionesGatewayIntPort crearValidacionesGateway(
            EspacioFisicoRepositoryInt espacioFisicoRepository,
            DocenteRepositoryInt docenteRepository,
            CursoRepositoryInt cursoRepository,
            FranjaHorariaRepositoryInt franjaHorariaRepository) {
        return new ValidacionesFranjaHorariaGatewayImplAdapter(espacioFisicoRepository, docenteRepository, 
                                                cursoRepository, franjaHorariaRepository);
    }
    
    @Bean
    public Orquestadorvalidaciones crearOrquestadorValidaciones(ValidacionesGatewayIntPort validacionesGateway) {
        return new Orquestadorvalidaciones(validacionesGateway);
    }
}
