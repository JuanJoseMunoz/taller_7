package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FranjaHoraria {
    private Integer id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private EspacioFisico objEspacioFisico;
    private Curso objCurso;

    public FranjaHoraria() {
    }
}
