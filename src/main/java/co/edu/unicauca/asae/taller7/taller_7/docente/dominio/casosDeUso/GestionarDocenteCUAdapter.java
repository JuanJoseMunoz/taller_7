package co.edu.unicauca.asae.taller7.taller_7.docente.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.comons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort {
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final FormateadorResultadosIntPort objDocenteFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort ObjGestionarDocenteGateway,
            FormateadorResultadosIntPort ObjDocenteFormateadorResultados) {
        this.objGestionarDocenteGateway = ObjGestionarDocenteGateway;
        this.objDocenteFormateadorResultados = ObjDocenteFormateadorResultados;
    }

    private boolean idValido(Integer id) {
        if (id == null || id <= 0) {
            this.objDocenteFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio("Error: el id del docente es inválido");
            return false;
        }
        return true;
    }

    private Docente existeDocente(Integer id) {
        if (!idValido(id))
            return null;

        Docente objDocente = this.objGestionarDocenteGateway.buscarDocentePorId(id);
        if (objDocente == null) {
            this.objDocenteFormateadorResultados
                    .retornarRespuestaErrorEntidadNoExiste("Error: no existe un docente con id " + id);
        }
        return objDocente;
    }

    private boolean datosBasicosValidos(Docente objDocente) {
        if (objDocente == null) {
            this.objDocenteFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio("Error: el docente no puede ser nulo");
            return false;
        }

        if (!objDocente.tieneNombreValido() || !objDocente.tieneApellidoValido() || !objDocente.tieneCorreoValido()) {
            this.objDocenteFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(
                            "Error: datos básicos inválidos para el docente (nombre, apellido o correo)");
            return false;
        }

        return true;
    }

    @Override
    public Docente crearDocente(Docente objDocente) {

        Docente objDocenteCreado = null;

        if (!datosBasicosValidos(objDocente)) {
            return null;
        }

        if (this.objGestionarDocenteGateway.existeDocente(objDocente.getId())) {
            this.objDocenteFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("Error: ya existe un docente con ese id");
        } else {
            objDocenteCreado = this.objGestionarDocenteGateway.guardarDocente(objDocente);
        }

        return objDocenteCreado;
    }

    @Override
    public Docente buscarDocentePorId(Integer id) {
        return existeDocente(id);
    }

    @Override
    public List<Docente> listarDocentes() {
        List<Docente> listaDocentes = objGestionarDocenteGateway.listarDocentes();
        return listaDocentes;
    }

    @Override
    public Docente actualizarDocente(Docente objDocente) {
        if (objDocente == null || !idValido(objDocente.getId()))
            return null;

        if (!this.objGestionarDocenteGateway.existeDocente(objDocente.getId())) {
            this.objDocenteFormateadorResultados
                    .retornarRespuestaErrorEntidadNoExiste("No existe docente con id " + objDocente.getId());
            return null;
        }

        if (!datosBasicosValidos(objDocente))
            return null;

        Docente objDocenteActualizado = this.objGestionarDocenteGateway.actualizarDocente(objDocente);
        return objDocenteActualizado;
    }

    @Override
    public Docente eliminarDocente(Integer id) {
        Docente objDocente = existeDocente(id);
        if (objDocente == null)
            return null;

        Docente objDocenteEliminado = this.objGestionarDocenteGateway.eliminarDocente(id);
        return objDocenteEliminado;
    }
}
