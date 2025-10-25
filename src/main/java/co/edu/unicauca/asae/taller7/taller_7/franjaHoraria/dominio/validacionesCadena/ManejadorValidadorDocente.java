package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena;

import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;

public abstract class ManejadorValidadorDocente {
    private ManejadorValidadorDocente next;
    
    public abstract void validar(DocenteDTOPeticion docente);

    public void setNext(ManejadorValidadorDocente next) {
        this.next = next;
    }
     
    public void validarSiguiente(DocenteDTOPeticion docente) {
        if (next != null) {
            next.validar(docente);
        }
    }
}
