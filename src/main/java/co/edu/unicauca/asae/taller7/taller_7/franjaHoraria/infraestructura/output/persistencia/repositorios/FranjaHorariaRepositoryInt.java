package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

public interface FranjaHorariaRepositoryInt extends CrudRepository<FranjaHorariaEntity, Integer>{
    
    Iterable<FranjaHorariaEntity> findByobjCursoIdCurso(Integer idCurso);
    
    @Query("SELECT COUNT(*) FROM EspacioFisico e JOIN e.franjasHorarias f WHERE e.id = :id AND f.dia = :dia AND f.hora_inicio < :horaInicio AND f.hora_fin > :horaFin") 
    int isEspacioFisicoOcupado(@Param("id") Integer id, @Param("dia") String dia, @Param("horaInicio") LocalTime horaInicio, @Param("horaFin") LocalTime horaFin);

    @Query(value = "SELECT COUNT(*) FROM docentes d JOIN cursosdocente cd ON d.IdDocente = cd.idDocente JOIN cursos c ON cd.idCurso = c.idCurso JOIN franjas_horarias f ON c.idCurso = f.curso_id WHERE d.IdDocente = :id AND f.dia = :dia AND f.hora_inicio < :horaFin AND f.hora_fin > :horaInicio", nativeQuery = true)
    int isDocenteOcupado(@Param("id") Integer id, @Param("dia") String dia, @Param("horaInicio") LocalTime horaInicio, @Param("horaFin") LocalTime horaFin);

    @Modifying
    @Query(value = "DELETE FROM franjas_horarias WHERE curso_id = :id", nativeQuery = true)  
    public int eliminarFranjasByCurso(@Param("id") Integer id);
}
