package co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.output;

import java.time.LocalTime;
import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;

public interface GestionarDocenteGatewayIntPort {
    public boolean existeDocente(Integer id);

    public Docente guardarDocente(Docente objDocente);

    public Docente buscarDocentePorId(Integer id);

    public List<Docente> listarDocentes();

    public boolean estaOcupadoDocente(Integer idDocente, String dia, LocalTime horaInicio, LocalTime horaFin);

    public boolean existeDocentePorCorreo(String correo);

    public Docente actualizarDocente(Docente objDocente);

    public Docente eliminarDocente(Integer id);
}
