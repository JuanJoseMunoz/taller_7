package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena;

import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.ValidacionesGatewayIntPort;

public class ValidadorCorreoDocente extends ManejadorValidadorDocente {
    private ValidacionesGatewayIntPort validacionesGateway;

    public ValidadorCorreoDocente(ValidacionesGatewayIntPort validacionesGateway) {
        this.validacionesGateway = validacionesGateway;
    }

    @Override
    public void validar(DocenteDTOPeticion docente) {
        System.out.println("\nValidando que el correo del docente no esté duplicado...");
        if (validacionesGateway.existeDocenteByCorreo(docente.getCorreo())) {
            throw new ReglaNegocioExcepcion("Ya existe un docente con el correo: " + docente.getCorreo());
        }
        
        validarSiguiente(docente);
    }
    
}
