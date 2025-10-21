package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.FranjaHoraria;

public interface GestionarFranjaHorariaCUIntPort {

    public FranjaHoraria crearFranjaHoraria(FranjaHoraria objFranjaHoraria);

    public FranjaHoraria buscarFranjaHorariaPorId(Integer id);

    public List<FranjaHoraria> listarFranjaHorarias();

    public FranjaHoraria actualizarFranjaHoraria(FranjaHoraria objFranjaHoraria);

    public FranjaHoraria eliminarFranjaHoraria(Integer id);

    public FranjaHoraria buscarFranjaHorariaPorCurso(Integer id);
    
}
