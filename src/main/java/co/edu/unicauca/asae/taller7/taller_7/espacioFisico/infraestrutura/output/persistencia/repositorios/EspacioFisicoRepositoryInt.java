package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.entidades.EspacioFisicoEntity;

public interface EspacioFisicoRepositoryInt extends JpaRepository<EspacioFisicoEntity, Integer> {
    
    List<EspacioFisicoEntity> findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombreAsc(String nombre, Integer capacidadMinima);
    
    boolean existsByNombre(String nombre);
    
    @Modifying
    @Query(value = "UPDATE espacios_fisicos SET estado = :estado WHERE id = :id", nativeQuery = true)
    int actualizarEstado(@Param("id") Integer id, @Param("estado") String estado);
    
    @Query("SELECT CASE WHEN COUNT(fh) > 0 THEN true ELSE false END FROM FranjaHorariaEntity fh " +
           "WHERE fh.objEspacioFisico.id = :idEspacioFisico AND fh.dia = :dia " +
           "AND fh.horaInicio < :horaFin AND fh.horaFin > :horaInicio")
    boolean existeFranjaHorariaEnEspacioFisico(@Param("idEspacioFisico") Integer idEspacioFisico, @Param("dia") String dia, @Param("horaInicio") java.time.LocalTime horaInicio, @Param("horaFin") java.time.LocalTime horaFin);
}
