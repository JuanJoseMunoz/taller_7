package co.edu.unicauca.asae.taller7.taller_7.docente.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.comons.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.input.GestionarOficinaCUIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.output.GestionarOficinaGetwayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Oficina;

public class GestionarOficinaCUAdapter implements GestionarOficinaCUIntPort {
    private final GestionarOficinaGetwayIntPort objGestionarOficinaGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarOficinaCUAdapter(GestionarOficinaGetwayIntPort objGestionarOficinaGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarOficinaGateway = objGestionarOficinaGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    private boolean idValido(Integer id) {
        if (id == null || id <= 0) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio("Error: el id de la oficina es inválido");
            return false;
        }
        return true;
    }

    private Oficina existeOficina(Integer id) {
        if (!idValido(id))
            return null;

        Oficina oficina = this.objGestionarOficinaGateway.buscarOficinaPorId(id);
        if (oficina == null) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadNoExiste("Error: no existe una oficina con id " + id);
        }
        return oficina;
    }

    private boolean datosBasicosValidos(Oficina oficina) {
        if (oficina == null) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio("La oficina no puede ser nula");
            return false;
        }
        if (!oficina.nombreValido() || !oficina.ubicacionValida()) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio("Nombre o ubicación de la oficina no son válidos");
            return false;
        }
        return true;
    }

    @Override
    public Oficina crearOficina(Oficina oficina) {
        Oficina creada = null;

        if (!datosBasicosValidos(oficina))
            return null;

        if (oficina.getId() != null &&
                this.objGestionarOficinaGateway.existeOficina(oficina.getId())) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("Error: ya existe una oficina con ese id");
        } else {
            creada = this.objGestionarOficinaGateway.guardarOficina(oficina);
        }
        return creada;
    }

    @Override
    public Oficina buscarOficinaPorId(Integer id) {
        return existeOficina(id);
    }

    @Override
    public List<Oficina> listarOficinas() {
        return this.objGestionarOficinaGateway.listarOficinas();
    }

    @Override
    public Oficina actualizarOficina(Oficina oficina) {
        if (oficina == null || !idValido(oficina.getId()))
            return null;

        if (!this.objGestionarOficinaGateway.existeOficina(oficina.getId())) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadNoExiste("No existe una oficina con id " + oficina.getId());
            return null;
        }

        if (!datosBasicosValidos(oficina))
            return null;

        return this.objGestionarOficinaGateway.actualizarOficina(oficina);
    }

    @Override
    public Oficina eliminarOficina(Integer id) {
        Oficina existente = existeOficina(id);
        if (existente == null)
            return null;

        return this.objGestionarOficinaGateway.eliminarOficina(id);
    }
}
