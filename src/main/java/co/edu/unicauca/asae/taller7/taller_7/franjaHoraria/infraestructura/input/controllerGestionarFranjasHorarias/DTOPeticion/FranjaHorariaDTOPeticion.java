package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion;

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
    @NotNull(message = "{franjaHoraria.dia.notNull}")
    @Size(max = 20, message = "{franjaHoraria.dia.size}")
    private String dia;

    @NotNull(message = "{franjaHoraria.horaInicio.notNull}")
    @FormatoHoraMilitar(message = "{franjaHoraria.horaInicio.formatoMilitar}")
    private String horaInicio;

    @NotNull(message = "{franjaHoraria.horaFin.notNull}")
    @FormatoHoraMilitar(message = "{franjaHoraria.horaFin.formatoMilitar}")
    private String horaFin; 

    @NotNull(message = "{franjaHoraria.idEspacioFisico.notNull}")
    @Min(value = 1, message = "{franjaHoraria.idEspacioFisico.min}")
    private Integer idEspacioFisico;

    @NotNull(message = "{franjaHoraria.curso.notNull}")
    @Min(value = 1, message = "{franjaHoraria.idCurso.min}")
    private Integer idCurso;
}
