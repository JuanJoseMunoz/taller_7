package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "oficina", source = "objOficina")
    @Mapping(target = "oficina.id", ignore = true)
    Docente mappearDePeticionADocente(DocenteDTOPeticion peticion);

    @Mapping(target = "oficina", source = "oficina")
    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente docente);

    List<DocenteDTORespuesta> mappearDeDocentesARespuesta(List<Docente> docentes);
}
