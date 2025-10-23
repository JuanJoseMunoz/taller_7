package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion;

import java.time.LocalTime;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FranjaHorariaDTOPeticion {
    @NotNull(message = "{franja.horaInicio.notnull}")
    @Size(max = 20, message = "{franja.dia.size}")
    private String dia;

    @NotNull(message = "{franja.horaInicio.notnull}")
    private LocalTime horaInicio;

    @NotNull(message = "{franja.horaFin.notnull}")
    private LocalTime horaFin; 

    @NotNull(message = "{franja.espacioFisico.notnull}")
    private Integer idEspacioFisico;

    @NotNull(message = "{franja.curso.notnull}")
    private Integer idCurso;

    @NotNull(message = "{franja.docente.notnull}")
    private List<Integer> docentesIds;
}
