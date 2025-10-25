package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena;

import java.util.Set;

import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.ValidacionesGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;

public class ValidadorDocenteDisponibleImpl extends ManejadorValidadorFranjaHoraria {
    private ValidacionesGatewayIntPort validacionesGateway;

    public ValidadorDocenteDisponibleImpl(ValidacionesGatewayIntPort validacionesGateway) {
        this.validacionesGateway = validacionesGateway;
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
                throw new ReglaNegocioExcepcion("No existe el docente con id: " + docente.getId()); 
            }

            int info = validacionesGateway.isDocenteOcupado(docente.getId(), franjaHoraria.getDia(), franjaHoraria.getHoraInicio(), franjaHoraria.getHoraFin());

            System.out.println("El docente" + docente.getNombre() + " ocupado: " + info);

            if (info == 1) {
                String mensaje = String.format(
                        "El docente %s %s ya está ocupado",
                        docente.getNombre(),
                        docente.getApellido(),
                        docente.getId(),
                        franjaHoraria.getDia(),
                        franjaHoraria.getHoraInicio(),
                        franjaHoraria.getHoraFin());
                throw new ReglaNegocioExcepcion(mensaje);
            }
        }
        
        validarSiguiente(franjaHoraria);
    }

}
