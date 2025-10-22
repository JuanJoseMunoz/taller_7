package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EspacioFisicoDTORespuesta {
    
    private Integer id;
    private String nombre;
    private int capacidad;
    private String estado;
    
    public EspacioFisicoDTORespuesta() {
    }
    
}