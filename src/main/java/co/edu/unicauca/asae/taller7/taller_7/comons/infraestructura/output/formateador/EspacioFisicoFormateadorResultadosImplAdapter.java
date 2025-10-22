package co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller7.taller_7.comons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;


@Service
public class EspacioFisicoFormateadorResultadosImplAdapter implements FormateadorResultadosIntPort {
    
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