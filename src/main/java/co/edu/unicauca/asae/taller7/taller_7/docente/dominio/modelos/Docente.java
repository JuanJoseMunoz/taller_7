package co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Docente extends Persona {
    private Oficina oficina;

    public Docente() {  
    }

    public Docente(Integer idPersona, String nombre, String apellido, String correo, Oficina oficina) {
        super(idPersona, nombre, apellido, correo);
        this.oficina = oficina;
    }

    public boolean docenteTieneOficina() {
        return oficina != null && oficina.getId() != null;
    }
}
