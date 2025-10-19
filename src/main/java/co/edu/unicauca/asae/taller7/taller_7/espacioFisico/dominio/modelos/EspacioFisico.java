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

    public boolean tieneNombreValido() {
        return this.nombre != null && !this.nombre.trim().isEmpty() && this.nombre.length() <= 255;
    }

    public boolean tieneCapacidadValida() {
        return this.capacidad > 0;
    }

    public boolean tieneEstadoValido() {
        return this.estado != null && 
               ("activo".equalsIgnoreCase(this.estado) || "inactivo".equalsIgnoreCase(this.estado));
    }

    public boolean tieneCapacidadSuficiente(int matriculaEstimada) {
        return this.capacidad >= matriculaEstimada;
    }
}
