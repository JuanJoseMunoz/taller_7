package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.formateador;

import org.springframework.stereotype.Service;
import co.edu.unicauca.asae.taller7.taller_7.comons.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;

@Service
public class EspacioFisicoFormateadorResultadosImplAdapter implements FormateadorResultadosIntPort {
    /* 
    @Override
    public Object retornarRespuestaErrorEntidadExiste(String mensaje) {
        Error error = new Error();
        error.setCodigoError(HttpStatus.CONFLICT.value());
        error.setMensaje(mensaje);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
     
    @Override
    public Object retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        Error error = new Error();
        error.setCodigoError(HttpStatus.BAD_REQUEST.value());
        error.setMensaje(mensaje);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    */
    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorEntidadNoExiste(String mensaje) {
        EntidadNoExisteException objException = new EntidadNoExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        ReglaNegocioExcepcion objException = new ReglaNegocioExcepcion(mensaje);
        throw objException;
    }
}