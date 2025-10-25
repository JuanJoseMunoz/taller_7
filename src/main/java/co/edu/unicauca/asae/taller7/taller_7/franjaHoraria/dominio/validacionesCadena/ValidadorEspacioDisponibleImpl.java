package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena;

import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.formateador.FormateadorResultadosImplAdapter;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.ValidacionesGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;

public class ValidadorEspacioDisponibleImpl extends ManejadorValidadorFranjaHoraria {

    private ValidacionesGatewayIntPort validacionesGateway;
    private FormateadorResultadosImplAdapter formateador;

    public ValidadorEspacioDisponibleImpl(ValidacionesGatewayIntPort validacionesGateway, FormateadorResultadosImplAdapter formateador) {
        this.validacionesGateway = validacionesGateway;
        this.formateador = formateador;
    }
 
    @Override
    public void validar(FranjaHorariaDTOPeticion franjaHoraria) {
        System.out.println("\nValidando espacio disponible para la franja horaria...");
        if (validacionesGateway.isEspacioFisicoOcupado(franjaHoraria.getIdEspacioFisico(), 
                                                      franjaHoraria.getDia(), 
                                                      franjaHoraria.getHoraInicio(), 
                                                      franjaHoraria.getHoraFin())) {
            formateador.retornarRespuestaErrorReglaDeNegocio("El espacio físico ya está ocupado en el horario especificado");
        }        
        validarSiguiente(franjaHoraria);
    }
}
