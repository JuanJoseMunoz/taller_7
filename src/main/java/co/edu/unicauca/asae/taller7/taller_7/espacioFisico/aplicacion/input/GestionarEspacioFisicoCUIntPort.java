package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.aplicacion.input;

import java.time.LocalTime;
import java.util.List;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;

public interface GestionarEspacioFisicoCUIntPort {
    
    EspacioFisico crear(EspacioFisico objEspacioFisico);
    
    List<EspacioFisico> listar(String patron, Integer capacidadMinima);
     
    Object actualizarEstado(Integer id, String estado);
     
    boolean estaOcupado(Integer idEspacioFisico, String dia, LocalTime horaInicio, LocalTime horaFin);
        
    EspacioFisico buscarById(Integer id);
}