package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.casosDeUso;

import java.time.LocalTime;
import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.comons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.aplicacion.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;

public class GestionarEspacioFisicoCUAdapter implements GestionarEspacioFisicoCUIntPort {
     
    private final GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway;
    private final FormateadorResultadosIntPort objEspacioFisicoFormateadorResultados;
     
    public GestionarEspacioFisicoCUAdapter(GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway, FormateadorResultadosIntPort objEspacioFisicoFormateadorResultados) {
        this.objGestionarEspacioFisicoGateway = objGestionarEspacioFisicoGateway;
        this.objEspacioFisicoFormateadorResultados = objEspacioFisicoFormateadorResultados;
    }

    private boolean datosValidos(EspacioFisico objEspacioFisico) {
        if (objEspacioFisico == null) {
            this.objEspacioFisicoFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("Error: el espacio fisico no puede ser nulo");
            return false;
        }

        if (!objEspacioFisico.tieneNombreValido() || !objEspacioFisico.tieneCapacidadValida() || !objEspacioFisico.tieneEstadoValido()) {
            this.objEspacioFisicoFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(
                            "Error: datos básicos inválidos para el espacio físico (nombre, capacidad o estado)");
            return false;
        }

        return true;
    }
    
    @Override
    public EspacioFisico crear(EspacioFisico objEspacioFisico) {
        EspacioFisico objEspacioFisicoCreado = null;

        if (!datosValidos(objEspacioFisico)) {
            return null;
        }

        if (this.objGestionarEspacioFisicoGateway.existeEspacioFisico(objEspacioFisico.getNombre())) {
            this.objEspacioFisicoFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("Error: ya existe un espacio físico con ese id");
        } else {
            objEspacioFisicoCreado = this.objGestionarEspacioFisicoGateway.guardarEspacioFisico(objEspacioFisico);
        }

        return objEspacioFisicoCreado;
    }
    
    @Override
    public List<EspacioFisico> listar(String nombre, Integer capacidadMinima) {
        return this.objGestionarEspacioFisicoGateway.listarEspaciosFisicos(nombre, capacidadMinima);
    }
    
    @Override
    public EspacioFisico actualizarEstado(Integer id, String estado) {
        if (this.objGestionarEspacioFisicoGateway.buscarEspacioFisicoPorId(id) == null) {
            this.objEspacioFisicoFormateadorResultados.retornarRespuestaErrorEntidadNoExiste("Error: no existe un espacio físico con id " + id);
        }
        EspacioFisico espacioActualizado = this.objGestionarEspacioFisicoGateway.actualizarEstadoEspacioFisico(id, estado);
        return espacioActualizado;
    }

    @Override
    public EspacioFisico buscarById(Integer id) {
        if (this.objGestionarEspacioFisicoGateway.buscarEspacioFisicoPorId(id) == null) {
            this.objEspacioFisicoFormateadorResultados.retornarRespuestaErrorEntidadNoExiste("Error: no existe un espacio físico con id " + id);
        }
        EspacioFisico espacioEncontrado = this.objGestionarEspacioFisicoGateway.buscarEspacioFisicoPorId(id);
        return espacioEncontrado;
    }

    @Override
    public boolean estaOcupado(Integer idEspacioFisico, String dia, LocalTime horaInicio,
            LocalTime horaFin) {
        // TODO Auto-generated method stub
        return false;
    }
}