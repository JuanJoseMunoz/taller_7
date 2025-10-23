package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta;

import java.time.LocalTime;
import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.DTORespuesta.EspacioFisicoDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FranjaHorariaDTORespuesta {
    private Integer id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private EspacioFisico nombreEspacioFisico;
    private CursoDTORespuesta curso;
    private List<DocenteDTORespuesta> docentes;
    private EspacioFisicoDTORespuesta espacioFisico;

    public FranjaHorariaDTORespuesta() {

    }
}
