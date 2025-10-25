package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.DTOPeticion;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EspacioFisicoDTOPeticion {
    
    @NotNull(message = "{espacioFisico.nombre.notNull}")
    @NotEmpty(message = "{espacioFisico.nombre.notEmpty}")
    @Size(max = 255, message = "{espacioFisico.nombre.min}")
    private String nombre;
    
    @Min(value = 1, message = "{espacioFisico.capacidad.min}")
    private int capacidad;
    
    @NotNull(message = "{espacioFisico.estado.notNull}")
    @Size(max = 8, message = "{espacioFisico.estado.size}")
    private String estado;
    
    public EspacioFisicoDTOPeticion() {
    }
}