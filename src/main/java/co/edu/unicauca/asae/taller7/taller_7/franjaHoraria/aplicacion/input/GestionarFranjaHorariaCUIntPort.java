package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.FranjaHoraria;

public interface GestionarFranjaHorariaCUIntPort {

    FranjaHoraria crearFranjaHoraria(FranjaHoraria objFranjaHoraria);

    List<FranjaHoraria> listarFranjasPorCurso(Integer idCurso);

    List<FranjaHoraria> listarFranjasPorDocente(Integer idDocente);

    List<Curso> listarCursosPorAsignatura(String nombreAsignatura);

    int eliminarFranjasPorCurso(Integer idCurso);

}
