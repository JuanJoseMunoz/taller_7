package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;

public interface EspacioFisicoRepositoryInt extends JpaRepository<EspacioFisico, Integer> {
    
    List<EspacioFisico> findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombreAsc(String nombre, Integer capacidad);

    @Modifying
    @Query("UPDATE EspacioFisico ef SET ef.estado = :estado WHERE ef.id = :id")
    public int actualizarEstado(@Param("id") Integer id, @Param("estado") String estado);
}
