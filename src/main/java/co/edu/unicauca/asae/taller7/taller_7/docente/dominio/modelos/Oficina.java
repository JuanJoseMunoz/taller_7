package co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Oficina {
    private Integer id;
    private String nombre;
    private String ubicacion;

    public Oficina() {}

    public boolean nombreValido() {
        return nombre != null && !nombre.trim().isEmpty() && nombre.length() <= 50;
    }

    public boolean ubicacionValida() {
        return ubicacion != null && !ubicacion.trim().isEmpty() && ubicacion.length() <= 100;
    }
}
