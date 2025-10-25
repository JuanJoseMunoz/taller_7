package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHorariaDeDocenteDTORespuesta {
    private int id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private CursoDTORespuesta curso;
    private EspacioFisicoDTORespuesta espacioFisico;
}
