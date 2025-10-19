package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.comons.output.FormateadorResultadosIntPort;
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
    
    @Override
    public List<EspacioFisico> listarEspaciosFisicos(String patron, Integer capacidadMinima) {
        return this.objGestionarEspacioFisicoGateway.listarEspaciosFisicos(patron, capacidadMinima);
    }
    
    @Override
    public Object actualizarEstadoEspacioFisico(Integer id, String estado) {
        if (!this.objGestionarEspacioFisicoGateway.existeEspacioFisico(id)) {
            this.objEspacioFisicoFormateadorResultados.retornarRespuestaErrorEntidadNoExiste("Error: no existe un espacio físico con id " + id);
        }
        EspacioFisico espacioActualizado = this.objGestionarEspacioFisicoGateway.actualizarEstadoEspacioFisico(id, estado);
        return espacioActualizado;
    }

    @Override
    public boolean estaOcupadoEspacioFisico(String dia, String horaInicio, String horaFin, Integer idEspacioFisico) {
        return this.objGestionarEspacioFisicoGateway.estaOcupadoEspacioFisico(dia, horaInicio, horaFin, idEspacioFisico);
    }

    @Override
    public EspacioFisico buscarEspacioFisicoPorId(Integer id) {
        return this.objGestionarEspacioFisicoGateway.buscarEspacioFisicoPorId(id);
    }
}