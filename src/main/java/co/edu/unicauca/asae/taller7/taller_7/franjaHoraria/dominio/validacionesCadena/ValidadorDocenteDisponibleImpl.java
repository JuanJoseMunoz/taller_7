package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena;

import java.time.LocalTime;
import java.util.Set;

import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.formateador.FormateadorResultadosImplAdapter;
import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.ValidacionesGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;

public class ValidadorDocenteDisponibleImpl extends ManejadorValidadorFranjaHoraria {
    private ValidacionesGatewayIntPort validacionesGateway;
    private final FormateadorResultadosImplAdapter formateador;

    public ValidadorDocenteDisponibleImpl(ValidacionesGatewayIntPort validacionesGateway,
            FormateadorResultadosImplAdapter formateador) {
        this.validacionesGateway = validacionesGateway;
        this.formateador = formateador;
    }

    @Override
    public void validar(FranjaHorariaDTOPeticion franjaHoraria) {
        System.out.println("\nValidando disponibilidad del docente para la franja horaria...");

        Set<Docente> docentes = validacionesGateway.obtenerDocentesDeCurso(franjaHoraria.getIdCurso());

        if (docentes.isEmpty()) {
            return; 
        }

        for (Docente docente : docentes) {
            System.out.println("Validando docente con ID: " + docente.getId());

            if (!validacionesGateway.existeDocente(docente.getId())) {
                formateador.retornarRespuestaErrorEntidadNoExiste("No existe el docente con id: " + docente.getId()); 
            }

            int bandera = validacionesGateway.isDocenteOcupado(docente.getId(), franjaHoraria.getDia(), LocalTime.parse(franjaHoraria.getHoraInicio()) , LocalTime.parse(franjaHoraria.getHoraFin()));

            if (bandera == 1) {
                String mensaje = String.format("El docente no esta disponible en la franja horaria");
                formateador.retornarRespuestaErrorReglaDeNegocio(mensaje);
            }
        }
        
        validarSiguiente(franjaHoraria);
    }

}
