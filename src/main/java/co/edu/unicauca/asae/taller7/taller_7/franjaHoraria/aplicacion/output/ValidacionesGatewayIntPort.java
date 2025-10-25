package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output;

import java.time.LocalTime;
import java.util.Set;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;

public interface ValidacionesGatewayIntPort {
    boolean isEspacioFisicoOcupado(Integer idEspacioFisico, String dia, LocalTime horaInicio, LocalTime horaFin);
    int isDocenteOcupado(Integer idDocente, String dia, LocalTime horaInicio, LocalTime horaFin);
    boolean existeEspacioFisico(Integer idEspacioFisico);
    boolean existeDocente(Integer idDocente);
    boolean existeCurso(Integer idCurso);
    boolean existeDocenteByCorreo(String correo);
    Set<Docente> obtenerDocentesDeCurso(int cursoId);
}
