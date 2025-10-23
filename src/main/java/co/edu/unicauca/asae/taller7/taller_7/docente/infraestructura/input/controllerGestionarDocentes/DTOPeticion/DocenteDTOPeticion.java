package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Oficina;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTOPeticion {

    /* 
    @Positive(message = "{docente.id.positive}")
    private Integer id;
    */

    @Size(min = 2, max = 15, message = "{docente.nombre.size}")
    private String nombre;

    @Size(min = 2, max = 15, message = "{docente.apellido.size}")
    private String apellido;

    @Email(message = "{docente.correo.email}")
    @Size(min = 5, max = 30, message = "{docente.correo.size}")
    private String correo;

    private OficinaDTOPeticion objOficina;
}
