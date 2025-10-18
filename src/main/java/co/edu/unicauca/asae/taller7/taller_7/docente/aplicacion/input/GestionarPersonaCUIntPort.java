package co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Persona;

public interface GestionarPersonaCUIntPort {
    public Persona crearPersona(Persona objOficina);

    public Persona buscarPersonaPorId(Integer id);

    public List<Persona> listarPersonas();

    public Persona actualizarPersona(Persona objPersona);

    public Persona eliminarPersona(Integer id);
}
