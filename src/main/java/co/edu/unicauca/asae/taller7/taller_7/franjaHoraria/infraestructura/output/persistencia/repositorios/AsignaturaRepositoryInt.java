package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades.AsignaturaEntity;

public interface AsignaturaRepositoryInt extends JpaRepository<AsignaturaEntity, Integer>{
    
}
