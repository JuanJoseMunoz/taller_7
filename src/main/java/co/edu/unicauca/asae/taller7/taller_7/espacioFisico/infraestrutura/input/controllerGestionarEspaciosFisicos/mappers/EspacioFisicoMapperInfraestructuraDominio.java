package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.DTOPeticion.EspacioFisicoDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.DTORespuesta.EspacioFisicoDTORespuesta;

@Mapper(componentModel = "spring")
public interface EspacioFisicoMapperInfraestructuraDominio {
    @Mapping(target = "id", ignore = true)
    EspacioFisico mappearDePeticionAEspacioFisico(EspacioFisicoDTOPeticion peticion);

    EspacioFisicoDTORespuesta mappearDeEspacioFisicoARespuesta(EspacioFisico objProducto);

    List<EspacioFisicoDTORespuesta> mappearDeEspaciosFisicosARespuesta(List<EspacioFisico> espaciosFisicos);
}