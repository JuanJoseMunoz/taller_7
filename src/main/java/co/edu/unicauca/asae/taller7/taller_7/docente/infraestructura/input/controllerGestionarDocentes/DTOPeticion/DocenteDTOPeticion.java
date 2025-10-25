package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTOPeticion {

    @NotEmpty(message = "{docente.nombre.notEmpty}")
    @Size(min = 2, max = 15, message = "{docente.nombre.size}")
    private String nombre;

    @NotEmpty(message = "{docente.apellido.notEmpty}")
    @Size(min = 2, max = 15, message = "{docente.apellido.size}")
    private String apellido;

    @NotEmpty(message = "{docente.correo.notEmpty}")
    @Email(message = "{docente.correo.email}")
    @Size(min = 5, max = 30, message = "{docente.correo.size}")
    private String correo;

    @NotNull(message = "{docente.oficina.notNull}")
    private OficinaDTOPeticion objOficina;
}
