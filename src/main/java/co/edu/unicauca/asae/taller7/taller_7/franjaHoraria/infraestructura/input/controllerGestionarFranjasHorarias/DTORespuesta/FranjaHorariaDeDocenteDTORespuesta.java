package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class FranjaHorariaDeDocenteDTORespuesta {
    private Integer id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String nombreEspacioFisico;
    private Integer capacidadEspacioFisico;
    private String nombreCurso;
    private String nombreAsignatura;

    public FranjaHorariaDeDocenteDTORespuesta() {

    }
}
