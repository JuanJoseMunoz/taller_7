package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;

public abstract class ManejadorValidadorFranjaHoraria {

    private ManejadorValidadorFranjaHoraria next;
    public abstract void validar(FranjaHorariaDTOPeticion franjaHoraria);

    public void setNext(ManejadorValidadorFranjaHoraria next) {
        this.next = next;
    }
     
    public void validarSiguiente(FranjaHorariaDTOPeticion franjaHoraria) {
        if (next != null) {
            next.validar(franjaHoraria);
        }
    }
    
}
