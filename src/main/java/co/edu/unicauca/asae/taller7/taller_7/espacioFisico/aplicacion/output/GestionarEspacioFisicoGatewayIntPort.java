package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.aplicacion.output;
import java.util.List;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;

public interface GestionarEspacioFisicoGatewayIntPort {
    
    EspacioFisico guardarEspacioFisico(EspacioFisico objEspacioFisico);
    
    List<EspacioFisico> listarEspaciosFisicos(String nombre, Integer capacidadMinima);
    
    boolean existeEspacioFisico(String nombre);
        
    EspacioFisico actualizarEstadoEspacioFisico(Integer id, String estado);
    
    EspacioFisico buscarEspacioFisicoPorId(Integer id);
}