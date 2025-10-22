package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Asignatura {
    
    private Integer id;
    private String nombre;
    private Integer codigo;

    public Asignatura() {
    }
}
