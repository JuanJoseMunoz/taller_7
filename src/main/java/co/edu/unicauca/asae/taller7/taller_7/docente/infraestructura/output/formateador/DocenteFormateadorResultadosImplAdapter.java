package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.formateador;

import co.edu.unicauca.asae.taller7.taller_7.comons.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;

public class DocenteFormateadorResultadosImplAdapter implements FormateadorResultadosIntPort {
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
