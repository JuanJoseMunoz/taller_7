package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.validaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.repositorios.EspacioFisicoRepositoryInt;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios.CursoRepositoryInt;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class CapacidadSuficienteValidator implements ConstraintValidator<CapacidadSuficiente, FranjaHorariaDTOPeticion> {

    @Autowired
    private CursoRepositoryInt cursoRepository;

    @Autowired
    private EspacioFisicoRepositoryInt espacioFisicoRepository;

    @Override
    public boolean isValid(FranjaHorariaDTOPeticion value, ConstraintValidatorContext context) {
        if (value == null || value.getIdCurso() == null || value.getIdEspacioFisico() == null) {
            return true;
        }

        var cursoOpt = cursoRepository.findById(value.getIdCurso());
        var espacioOpt = espacioFisicoRepository.findById(value.getIdEspacioFisico());

        if (cursoOpt.isEmpty() || espacioOpt.isEmpty()) {
            return true; 
        }

        CursoEntity curso = cursoOpt.get();
        EspacioFisicoEntity espacio = espacioOpt.get();

        if (curso.getMatriculaEstimada() != null && espacio.getCapacidad() != null) {
            return espacio.getCapacidad() >= curso.getMatriculaEstimada();
        }

        return true; 
    }
}