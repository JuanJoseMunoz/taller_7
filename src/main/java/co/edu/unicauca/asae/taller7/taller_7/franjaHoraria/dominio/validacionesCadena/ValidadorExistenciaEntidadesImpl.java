package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena;

import java.text.Format;
import java.text.Normalizer.Form;

import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.formateador.FormateadorResultadosImplAdapter;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.ValidacionesGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;

public class ValidadorExistenciaEntidadesImpl extends ManejadorValidadorFranjaHoraria {

    private ValidacionesGatewayIntPort validacionesGateway;
    private FormateadorResultadosImplAdapter formateador;

    public ValidadorExistenciaEntidadesImpl(ValidacionesGatewayIntPort validacionesGateway, FormateadorResultadosImplAdapter formateador) {
        this.validacionesGateway = validacionesGateway;
        this.formateador = formateador;
    }
    
    @Override
    public void validar(FranjaHorariaDTOPeticion franjaHoraria) {
        System.out.println("\nValidando que existe el espacio físico...");
        if (!validacionesGateway.existeEspacioFisico(franjaHoraria.getIdEspacioFisico())) {
            formateador.retornarRespuestaErrorEntidadNoExiste("El espacio fisico no existe");

        }
        
        System.out.println("\nValidando que existe el curso...");
        if (!validacionesGateway.existeCurso(franjaHoraria.getIdCurso())) {
            formateador.retornarRespuestaErrorEntidadNoExiste("El curso no existe");
        }

        validarSiguiente(franjaHoraria);
    }
}
