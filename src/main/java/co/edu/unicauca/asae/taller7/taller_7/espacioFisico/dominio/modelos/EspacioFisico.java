package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspacioFisico {

    private Integer id;
    private String nombre;
    private Integer capacidad;
    private String estado;

    public boolean tieneNombreValido() {
        return this.nombre != null && !this.nombre.trim().isEmpty() && this.nombre.length() <= 255;
    }

    public boolean tieneCapacidadValida() {
        return this.capacidad > 0;
    }

    public boolean tieneCapacidadSuficiente(int matriculaEstimada) {
        return this.capacidad >= matriculaEstimada;
    }
}
