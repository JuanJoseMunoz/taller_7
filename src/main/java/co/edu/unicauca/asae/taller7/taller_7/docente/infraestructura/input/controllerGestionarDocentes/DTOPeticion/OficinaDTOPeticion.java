package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OficinaDTOPeticion {
    
    @Size(min = 2, max = 50, message = "{oficina.nombre.size}")
    private String nombre;

    @Size(min = 2, max = 100, message = "{oficina.ubicacion.size}")
    private String ubicacion;

    public OficinaDTOPeticion() {
    }
}