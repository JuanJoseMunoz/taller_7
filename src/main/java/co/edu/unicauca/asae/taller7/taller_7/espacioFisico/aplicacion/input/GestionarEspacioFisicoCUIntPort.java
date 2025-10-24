package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.aplicacion.input;

import java.util.List;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;

public interface GestionarEspacioFisicoCUIntPort {
    
    EspacioFisico crear(EspacioFisico objEspacioFisico);
    
    List<EspacioFisico> listar(String nombre, Integer capacidadMinima);
     
    EspacioFisico actualizarEstado(Integer id, String estado);
             
    EspacioFisico buscarById(Integer id);
}