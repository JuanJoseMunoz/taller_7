package co.edu.unicauca.asae.taller7.taller_7.docente.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.comons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.input.GestionarPersonaCUIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.output.GestionarPersonaGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Persona;

public class GestionarPersonaCUAdapter implements GestionarPersonaCUIntPort {
    private final GestionarPersonaGatewayIntPort objGestionarPersonaGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarPersonaCUAdapter(GestionarPersonaGatewayIntPort objGestionarPersonaGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarPersonaGateway = objGestionarPersonaGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    private boolean idValido(Integer id) {
        if (id == null || id <= 0) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio("Error: el id de la persona es inválido");
            return false;
        }
        return true;
    }

    private Persona existePersona(Integer id) {
        if (!idValido(id))
            return null;

        Persona persona = this.objGestionarPersonaGateway.buscarPersonaPorId(id);
        if (persona == null) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadNoExiste("Error: no existe una persona con id " + id);
        }
        return persona;
    }

    private boolean datosBasicosValidos(Persona persona) {
        if (persona == null) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio("La persona no puede ser nula");
            return false;
        }
        if (!persona.tieneNombreValido() || !persona.tieneApellidoValido() || !persona.tieneCorreoValido()) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio("Error: nombre, apellido o correo inválidos");
            return false;
        }
        return true;
    }

    @Override
    public Persona crearPersona(Persona persona) {
        Persona creada = null;

        if (!datosBasicosValidos(persona))
            return null;

        if (persona.getId() != null &&
                this.objGestionarPersonaGateway.existePersona(persona.getId())) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("Error: ya existe una persona con ese id");
        } else {
            creada = this.objGestionarPersonaGateway.guardarPersona(persona);
        }
        return creada;
    }

    @Override
    public Persona buscarPersonaPorId(Integer id) {
        return existePersona(id);
    }

    @Override
    public List<Persona> listarPersonas() {
        return this.objGestionarPersonaGateway.listarPersonas();
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        if (persona == null || !idValido(persona.getId()))
            return null;

        if (!this.objGestionarPersonaGateway.existePersona(persona.getId())) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadNoExiste("No existe persona con id " + persona.getId());
            return null;
        }

        if (!datosBasicosValidos(persona))
            return null;

        return this.objGestionarPersonaGateway.actualizarPersona(persona);
    }

    @Override
    public Persona eliminarPersona(Integer id) {
        Persona existente = existePersona(id);
        if (existente == null)
            return null;

        return this.objGestionarPersonaGateway.eliminarPersona(id);
    }
}
