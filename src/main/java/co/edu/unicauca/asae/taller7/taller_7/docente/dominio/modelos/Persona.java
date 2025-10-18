package co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;

    public Persona() {
    }

    public boolean tieneNombreValido() {
        return nombre != null && nombre.length() >= 2 && nombre.length() <= 50;
    }

    public boolean tieneApellidoValido() {
        return apellido != null && apellido.length() >= 2 && apellido.length() <= 50;
    }

    public boolean tieneCorreoValido() {
        return correo != null && correo.contains("@unicauca.edu.co");
    }

}
