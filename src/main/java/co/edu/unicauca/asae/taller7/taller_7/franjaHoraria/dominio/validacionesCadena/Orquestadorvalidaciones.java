package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena;

import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.ValidacionesGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;

public class Orquestadorvalidaciones {
    
    private ValidacionesGatewayIntPort validacionesGateway;
    private ManejadorValidadorFranjaHoraria validadorFranjaHoraria;
    private ManejadorValidadorDocente validadorDocente;

    public Orquestadorvalidaciones(ValidacionesGatewayIntPort validacionesGateway) {
        this.validacionesGateway = validacionesGateway;
        ManejadorValidadorFranjaHoraria v1 = new ValidadorExistenciaEntidadesImpl(validacionesGateway);
        ManejadorValidadorFranjaHoraria v2 = new ValidadorEspacioDisponibleImpl(validacionesGateway);
        ManejadorValidadorFranjaHoraria v3 = new ValidadorDocenteDisponibleImpl(validacionesGateway);
        
        v1.setNext(v2);
        v2.setNext(v3);

        validadorFranjaHoraria = v1;
        
        ManejadorValidadorDocente vd1 = new ValidadorCorreoDocente(validacionesGateway);
        validadorDocente = vd1;
    }
    
    public void ejecutarValidacionesFranjaHoraria(FranjaHorariaDTOPeticion franjaDTO) {
        validadorFranjaHoraria.validar(franjaDTO);
    }
    
    public void ejecutarValidacionesDocente(DocenteDTOPeticion docenteDTO) {
        validadorDocente.validar(docenteDTO);
    }

}
