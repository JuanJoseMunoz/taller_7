package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena;

import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.ValidacionesGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;

public class ValidadorExistenciaEntidadesImpl extends ManejadorValidadorFranjaHoraria {

    private ValidacionesGatewayIntPort validacionesGateway;

    public ValidadorExistenciaEntidadesImpl(ValidacionesGatewayIntPort validacionesGateway) {
        this.validacionesGateway = validacionesGateway;
    }
    
    @Override
    public void validar(FranjaHorariaDTOPeticion franjaHoraria) {
        System.out.println("\nValidando que existe el espacio físico...");
        if (!validacionesGateway.existeEspacioFisico(franjaHoraria.getIdEspacioFisico())) {
            throw new EntidadNoExisteException("El espacio físico con ID " + franjaHoraria.getIdEspacioFisico() + " no existe");
        }
        
        System.out.println("\nValidando que existe el curso...");
        if (!validacionesGateway.existeCurso(franjaHoraria.getIdCurso())) {
            throw new EntidadNoExisteException("El curso con ID " + franjaHoraria.getIdCurso() + " no existe");
        }
        
        System.out.println("\nValidando que existe(n) el(los) docente(s))...");
        for (Integer idDocente : franjaHoraria.getDocentesIds()) {
            if (!validacionesGateway.existeDocente(idDocente)) {
                throw new EntidadNoExisteException("El docente con ID " + idDocente + " no existe");
            }
        }
        validarSiguiente(franjaHoraria);
    }
}
