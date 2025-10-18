package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.Curso;

public interface CursoRepositoryInt extends JpaRepository<Curso, Integer>{
    
    public Iterable<Curso> findByobjAsignaturaNombre(String nombreAsig); 

    @Query("SELECT c, f, e FROM Curso c JOIN c.franjasHorarias f JOIN f.objEspacioFisico e WHERE c.idCurso = :id")
    Iterable<Object[]> consultarByCurso(@Param("id") Integer id);
    
}
