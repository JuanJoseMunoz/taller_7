package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTORespuesta {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private Integer oficinaId;

    public DocenteDTORespuesta() {
    }
}
