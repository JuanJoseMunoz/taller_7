package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena;

import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.ValidacionesGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;

public class ValidadorDocenteDisponibleImpl extends ManejadorValidadorFranjaHoraria {
    private ValidacionesGatewayIntPort validacionesGateway;

    public ValidadorDocenteDisponibleImpl(ValidacionesGatewayIntPort validacionesGateway) {
        this.validacionesGateway = validacionesGateway;
    }

    @Override
    public void validar(FranjaHorariaDTOPeticion franjaHoraria) {
        System.out.println("\nValidando disponibilidad del docente para la franja horaria...");
        for (Integer idDocente : franjaHoraria.getDocentesIds()) {
            System.out.println("Validando docente ID: " + idDocente);
            System.out.println("Día: " + franjaHoraria.getDia());
            System.out.println("Hora inicio: " + franjaHoraria.getHoraInicio());
            System.out.println("Hora fin: " + franjaHoraria.getHoraFin());
            int resultado = validacionesGateway.isDocenteOcupado(idDocente, 
                                                            franjaHoraria.getDia(), 
                                                            franjaHoraria.getHoraInicio(), 
                                                            franjaHoraria.getHoraFin());
            System.out.println("Resultado isDocenteOcupado: " + resultado);
            if (resultado == 1) {
                throw new ReglaNegocioExcepcion("El docente con ID " + idDocente + " ya tiene una franja horaria asignada en el mismo horario");
            }
        }      
        validarSiguiente(franjaHoraria);
    }
    
}
