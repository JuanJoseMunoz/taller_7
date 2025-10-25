package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena;

import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.formateador.FormateadorResultadosImplAdapter;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.ValidacionesGatewayIntPort;

public class ValidadorCorreoDocente extends ManejadorValidadorDocente {
    private ValidacionesGatewayIntPort validacionesGateway;
    private FormateadorResultadosImplAdapter formateador;

    public ValidadorCorreoDocente(ValidacionesGatewayIntPort validacionesGateway, FormateadorResultadosImplAdapter formateador) {
        this.validacionesGateway = validacionesGateway; 
        this.formateador = formateador;
    }

    @Override
    public void validar(DocenteDTOPeticion docente) {
        System.out.println("\nValidando que el correo del docente no esté duplicado...");
        if (validacionesGateway.existeDocenteByCorreo(docente.getCorreo())) {
            formateador.retornarRespuestaErrorReglaDeNegocio("Ya existe un docente con el correo ingresado");
        }
        
        validarSiguiente(docente);
    }
    
}
