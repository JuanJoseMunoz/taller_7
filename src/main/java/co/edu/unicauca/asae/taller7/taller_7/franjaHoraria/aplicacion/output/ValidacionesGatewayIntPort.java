package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output;

import java.time.LocalTime;

public interface ValidacionesGatewayIntPort {
    boolean isEspacioFisicoOcupado(Integer idEspacioFisico, String dia, LocalTime horaInicio, LocalTime horaFin);
    int isDocenteOcupado(Integer idDocente, String dia, LocalTime horaInicio, LocalTime horaFin);
    boolean existeEspacioFisico(Integer idEspacioFisico);
    boolean existeDocente(Integer idDocente);
    boolean existeCurso(Integer idCurso);
    boolean existeDocenteByCorreo(String correo);
}
