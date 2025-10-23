package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;

public interface CursoRepositoryInt extends JpaRepository<CursoEntity, Integer> {

    List<CursoEntity> findByObjAsignaturaNombre(String nombreAsignatura);

    @Query("SELECT c, f, e FROM CursoEntity c JOIN c.franjasHorarias f JOIN f.objEspacioFisico e WHERE c.idCurso = :id")
    Iterable<Object[]> consultarByCurso(@Param("id") Integer id);;
}
