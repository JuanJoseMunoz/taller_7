package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.entidades.EspacioFisicoEntity;

public interface EspacioFisicoRepositoryInt extends JpaRepository<EspacioFisicoEntity, Integer> {
    
    List<EspacioFisicoEntity> findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombreAsc(String nombre, Integer capacidadMinima);

    @Modifying
    @Query("UPDATE EspacioFisicoEntity ef SET ef.estado = :estado WHERE ef.id = :id")
    public int actualizarEstado(@Param("id") Integer id, @Param("estado") String estado);
    
    @Query("SELECT CASE WHEN COUNT(fh) > 0 THEN true ELSE false END FROM FranjaHorariaEntity fh " +
           "JOIN fh.objEspacioFisico ef " +
           "WHERE ef.id = :idEspacioFisico AND fh.dia = :dia " +
           "AND fh.horaInicio = :horaInicio AND fh.horaFin = :horaFin")
    boolean existeFranjaHorariaEnEspacioFisico(@Param("dia") String dia, 
                                               @Param("horaInicio") String horaInicio, 
                                               @Param("horaFin") String horaFin, 
                                               @Param("idEspacioFisico") Integer idEspacioFisico);
}
