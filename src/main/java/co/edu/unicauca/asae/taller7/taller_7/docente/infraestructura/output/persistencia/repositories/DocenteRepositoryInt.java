package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepositoryInt extends JpaRepository<DocenteEntity, Integer> {

    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM DocenteEntity d WHERE d.correo = :correo")
    boolean existsByCorreo(@Param("correo") String correo);
}
