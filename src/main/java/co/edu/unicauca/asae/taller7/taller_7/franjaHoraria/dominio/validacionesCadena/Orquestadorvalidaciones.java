package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena;

import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.formateador.FormateadorResultadosImplAdapter;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.ValidacionesGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;

public class Orquestadorvalidaciones {
    
    private ValidacionesGatewayIntPort validacionesGateway;
    private FormateadorResultadosImplAdapter formateador;
    private ManejadorValidadorFranjaHoraria validadorFranjaHoraria;
    private ManejadorValidadorDocente validadorDocente;

    public Orquestadorvalidaciones(ValidacionesGatewayIntPort validacionesGateway, FormateadorResultadosImplAdapter formateador) {
        this.validacionesGateway = validacionesGateway;
        this.formateador = formateador;
        ManejadorValidadorFranjaHoraria v1 = new ValidadorExistenciaEntidadesImpl(validacionesGateway, formateador);
        ManejadorValidadorFranjaHoraria v2 = new ValidadorEspacioDisponibleImpl(validacionesGateway, formateador);
        ManejadorValidadorFranjaHoraria v3 = new ValidadorDocenteDisponibleImpl(validacionesGateway, formateador);
        
        v1.setNext(v2);
        v2.setNext(v3);

        validadorFranjaHoraria = v1;
        
        ManejadorValidadorDocente vd1 = new ValidadorCorreoDocente(validacionesGateway, formateador);
        validadorDocente = vd1;
    }
    
    public void ejecutarValidacionesFranjaHoraria(FranjaHorariaDTOPeticion franjaDTO) {
        validadorFranjaHoraria.validar(franjaDTO);
    }
    
    public void ejecutarValidacionesDocente(DocenteDTOPeticion docenteDTO) {
        validadorDocente.validar(docenteDTO);
    }

}
