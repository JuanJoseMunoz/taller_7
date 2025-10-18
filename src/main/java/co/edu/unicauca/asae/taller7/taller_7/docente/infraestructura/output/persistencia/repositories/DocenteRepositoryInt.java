package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepositoryInt extends JpaRepository<DocenteEntity, Integer> {

}
