package co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;

public interface GestionarDocenteGetwayIntPort {
    public boolean existeDocente(Integer id);

    public Docente guardarDocente(Docente objDocente);

    public Docente buscarDocentePorId(Integer id);

    public List<Docente> listarDocentes();

    public Docente actualizarDocente(Docente objDocente);

    public Docente eliminarDocente(Integer id);
}
