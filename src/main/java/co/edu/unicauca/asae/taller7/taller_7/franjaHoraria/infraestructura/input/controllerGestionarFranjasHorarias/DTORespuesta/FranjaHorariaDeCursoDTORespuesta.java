package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta;

import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FranjaHorariaDeCursoDTORespuesta {
    private Integer id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String nombreEspacioFisico;
    private Integer capacidadEspacioFisico;
    private List<String> nombresDocentes;

    public FranjaHorariaDeCursoDTORespuesta() {

    }
}
