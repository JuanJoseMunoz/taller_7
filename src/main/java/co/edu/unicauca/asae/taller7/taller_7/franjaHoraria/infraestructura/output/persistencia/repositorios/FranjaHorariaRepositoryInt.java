package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

public interface FranjaHorariaRepositoryInt extends JpaRepository<FranjaHorariaEntity, Integer>{
    
    List<FranjaHorariaEntity> findByObjCursoIdCurso(Integer idCurso);
    /* 
    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM FranjaHorariaEntity f " +
           "WHERE f.objEspacioFisico.id = :idEspacioFisico AND f.dia = :dia " +
           "AND f.horaInicio < :horaFin AND f.horaFin > :horaInicio")
    boolean isEspacioFisicoOcupado(@Param("idEspacioFisico") Integer idEspacioFisico,  @Param("dia") String dia, @Param("horaInicio") LocalTime horaInicio, @Param("horaFin") LocalTime horaFin);
    */
    @Query("SELECT COUNT(*) FROM EspacioFisico e JOIN e.franjasHorarias f WHERE e.id = :id AND f.dia = :dia AND f.hora_inicio < :horaInicio AND f.hora_fin > :horaFin") 
    int isEspacioFisicoOcupado(@Param("id") Integer id, @Param("dia") String dia, @Param("horaInicio") LocalTime horaInicio, @Param("horaFin") LocalTime horaFin);

    @Query(value = "SELECT COUNT(*) FROM docentes d JOIN cursosdocente cd ON d.IdDocente = cd.idDocente JOIN cursos c ON cd.idCurso = c.idCurso JOIN franjas_horarias f ON c.idCurso = f.curso_id WHERE d.IdDocente = :id AND f.dia = :dia AND f.hora_inicio < :horaFin AND f.hora_fin > :horaInicio", nativeQuery = true)
    int isDocenteOcupado(@Param("id") Integer id, @Param("dia") String dia, @Param("horaInicio") LocalTime horaInicio, @Param("horaFin") LocalTime horaFin);

    @Query("SELECT c, f, e FROM Curso c JOIN c.franjasHorarias f JOIN f.objEspacioFisico e WHERE c.idCurso = :id")
    Iterable<Object[]> consultarByCurso(@Param("id") Integer id);

    @Modifying
    @Query(value = "DELETE FROM franjas_horarias WHERE curso_id = :id", nativeQuery = true)  
    public int eliminarFranjasByCurso(@Param("id") Integer id);

    @Query("SELECT f FROM FranjaHorariaEntity f " + "JOIN f.objCurso.listaDocentes d " + "WHERE d.idPersona = :idDocente")
    List<FranjaHorariaEntity> findByDocenteId(@Param("idDocente") Integer idDocente);
}
