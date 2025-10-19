package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EspacioFisico {

    private Integer id;

    private String nombre;
    private int capacidad;
    private String estado;

    public EspacioFisico() {
    }
}
