package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {
    Docente mappearDePeticionADocente(DocenteDTOPeticion peticion);

    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente docente);

    List<DocenteDTORespuesta> mappearDeDocentesARespuesta(List<Docente> docentes);
}
