package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.aplicacion.output;
import java.util.List;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;

public interface GestionarEspacioFisicoGatewayIntPort {
    
    List<EspacioFisico> listarEspaciosFisicos(String nombre, Integer capacidadMinima);
    
    boolean existeEspacioFisico(Integer id);
    
    boolean estaOcupadoEspacioFisico(String dia, String horaInicio, String horaFin, Integer idEspacioFisico);
    
    EspacioFisico actualizarEstadoEspacioFisico(Integer id, String estado);
    
    EspacioFisico buscarEspacioFisicoPorId(Integer id);
}