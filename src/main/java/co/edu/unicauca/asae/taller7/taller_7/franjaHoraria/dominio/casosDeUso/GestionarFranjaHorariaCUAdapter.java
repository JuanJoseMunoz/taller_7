package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.comons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.FranjaHoraria;

public class GestionarFranjaHorariaCUAdapter implements GestionarFranjaHorariaCUIntPort {

    private final GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway;
    private final FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados;

    public GestionarFranjaHorariaCUAdapter(GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        this.objGestionarFranjaHorariaGateway = objGestionarFranjaHorariaGateway;
        this.objFranjaHorariaFormateadorResultados = objFranjaHorariaFormateadorResultados;
    }

    @Override
    public FranjaHoraria crearFranjaHoraria(FranjaHoraria objFranjaHoraria) {
        return objGestionarFranjaHorariaGateway.guardarFranjaHoraria(objFranjaHoraria);
    }

    @Override
    public List<FranjaHoraria> listarFranjasPorCurso(Integer idCurso) {
        return objGestionarFranjaHorariaGateway.listarFranjasPorCurso(idCurso);
    }

    @Override
    public List<FranjaHoraria> listarFranjasPorDocente(Integer idDocente) {
        return this.objGestionarFranjaHorariaGateway.listarFranjasPorDocente(idDocente);
    }

    @Override
    public List<Curso> listarCursosPorAsignatura(String nombreAsignatura) {
        return null;
    }

    @Override
    public int eliminarFranjasPorCurso(Integer idCurso) {
        return objGestionarFranjaHorariaGateway.eliminarFranjasPorCurso(idCurso);
    }

    @Override
    public List<Object[]> obtenerDetalleFranjasCurso(int cursoId) {
        return objGestionarFranjaHorariaGateway.obtenerDetalleFranjasCurso(cursoId);
    }
}
