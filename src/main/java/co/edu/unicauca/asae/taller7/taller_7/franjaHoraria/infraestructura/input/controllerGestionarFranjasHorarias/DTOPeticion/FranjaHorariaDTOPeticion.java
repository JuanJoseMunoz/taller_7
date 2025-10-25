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
@CapacidadSuficiente(message = "{franjaHoraria.capacidadInsuficiente}")
public class FranjaHorariaDTOPeticion {
    @NotNull(message = "{franjaHoraria.dia.notnull}")
    @Size(max = 20, message = "{franjaHoraria.dia.size}")
    private String dia;

    @NotNull(message = "{franjaHoraria.horaInicio.notnull}")
    @FormatoHoraMilitar(message = "{franjaHoraria.horaInicio.formatoMilitar}")
    private LocalTime horaInicio;

    @NotNull(message = "{franjaHoraria.horaFin.notnull}")
    @FormatoHoraMilitar(message = "{franjaHoraria.horaFin.formatoMilitar}")
    private LocalTime horaFin; 

    @NotNull(message = "{franjaHoraria.idEspacioFisico.notnull}")
    @Min(value = 1, message = "{franjaHoraria.idEspacioFisico.min}")
    private Integer idEspacioFisico;

    @NotNull(message = "{franjaHoraria.curso.notnull}")
    @Min(value = 1, message = "{franjaHoraria.idCurso.min}")
    private Integer idCurso;
}
