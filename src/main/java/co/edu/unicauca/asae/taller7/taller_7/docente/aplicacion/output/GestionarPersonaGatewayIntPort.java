package co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Persona;

public interface GestionarPersonaGatewayIntPort {
    public boolean existePersona(Integer id);

    public Persona guardarPersona(Persona objOficina);

    public Persona buscarPersonaPorId(Integer id);

    public List<Persona> listarPersonas();

    public Persona actualizarPersona(Persona objPersona);

    public Persona eliminarPersona(Integer id);
}
