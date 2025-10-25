package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.validaciones.CapacidadSuficiente;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.validaciones.FormatoHoraMilitar;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@CapacidadSuficiente(message = "{franja.capacidadInsuficiente}")
public class FranjaHorariaDTOPeticion {
    @NotNull(message = "{franja.horaInicio.notnull}")
    @Size(max = 20, message = "{franja.dia.size}")
    private String dia;

    @NotNull(message = "{franja.horaInicio.notnull}")
    @FormatoHoraMilitar(message = "{franja.horaInicio.formatoMilitar}")
    private LocalTime horaInicio;

    @NotNull(message = "{franja.horaFin.notnull}")
    @FormatoHoraMilitar(message = "{franja.horaFin.formatoMilitar}")
    private LocalTime horaFin; 

    @NotNull(message = "{franja.idEspacioFisico.notnull}")
    private Integer idEspacioFisico;

    @NotNull(message = "{franja.curso.notnull}")
    @Min(value = 1, message = "{franja.idCurso.min}")
    private Integer idCurso;
}
