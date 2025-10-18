package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.Asignatura;

public interface AsignaturaRepositoryInt extends JpaRepository<Asignatura, Integer>{
    
}
