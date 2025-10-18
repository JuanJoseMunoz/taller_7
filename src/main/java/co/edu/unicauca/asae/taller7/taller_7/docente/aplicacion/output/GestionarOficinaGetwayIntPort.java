package co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Oficina;

public interface GestionarOficinaGetwayIntPort {
    public boolean existeOficina(Integer id);

    public Oficina guardarOficina(Oficina objOficina);

    public Oficina buscarOficinaPorId(Integer id);

    public List<Oficina> listarOficinas();

    public Oficina actualizarOficina(Oficina objOficina);

    public Oficina eliminarOficina(Integer id);
}
