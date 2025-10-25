package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTORespuesta {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
}
