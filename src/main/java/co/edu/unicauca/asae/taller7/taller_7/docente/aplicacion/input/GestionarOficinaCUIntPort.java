package co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Oficina;

public interface GestionarOficinaCUIntPort {
    
    public Oficina crearOficina(Oficina objOficina);

    public Oficina buscarOficinaPorId(Integer id);

    public List<Oficina> listarOficinas();

    public Oficina actualizarOficina(Oficina objOficina);

    public Oficina eliminarOficina(Integer id);
}
