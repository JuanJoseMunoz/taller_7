package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.aplicacion.input;

import java.time.LocalTime;
import java.util.List;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;

public interface GestionarEspacioFisicoCUIntPort {
    
    EspacioFisico crearEspacioFisico(EspacioFisico objEspacioFisico);
    
    List<EspacioFisico> listarEspaciosFisicos(String patron, Integer capacidadMinima);
     
    Object actualizarEstadoEspacioFisico(Integer id, String estado);
     
    boolean estaOcupadoEspacioFisico(Integer idEspacioFisico, String dia, LocalTime horaInicio, LocalTime horaFin);
        
    EspacioFisico buscarEspacioFisicoPorId(Integer id);
}