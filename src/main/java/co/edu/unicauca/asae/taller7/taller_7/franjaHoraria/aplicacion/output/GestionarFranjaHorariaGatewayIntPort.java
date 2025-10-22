package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.FranjaHoraria;

public interface GestionarFranjaHorariaGatewayIntPort {
    public FranjaHoraria guardarFranjaHoraria(FranjaHoraria objFranjaHoraria);
    
    public List<FranjaHoraria> listarFranjasPorCurso(Integer idCurso);
    
    public List<FranjaHoraria> listarFranjasPorDocente(Integer idDocente);
    
    public boolean existeCurso(Integer idCurso);
    
    public int eliminarFranjasPorCurso(Integer idCurso);
}
