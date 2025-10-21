package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.aplicacion.input;

import java.util.List;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;

public interface GestionarEspacioFisicoCUIntPort {
    
    EspacioFisico crearEspacioFisico(EspacioFisico objEspacioFisico);
    
    List<EspacioFisico> listarEspaciosFisicos(String patron, Integer capacidadMinima);
     
    Object actualizarEstadoEspacioFisico(Integer id, String estado);
     
    boolean estaOcupadoEspacioFisico(String dia, String horaInicio, String horaFin, Integer idEspacioFisico);
        
    EspacioFisico buscarEspacioFisicoPorId(Integer id);
}