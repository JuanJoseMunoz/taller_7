package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta;

import java.time.LocalTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHorariaDeCursoDTORespuesta {
    private Integer id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private EspacioFisicoDTORespuesta espacioFisico;
    private Set<DocenteDTORespuesta> docentes;

}
