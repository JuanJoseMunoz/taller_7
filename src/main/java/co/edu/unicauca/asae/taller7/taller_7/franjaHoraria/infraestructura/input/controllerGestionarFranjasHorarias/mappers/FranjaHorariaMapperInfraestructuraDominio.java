package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.FranjaHorariaDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.FranjaHorariaDeCursoDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.FranjaHorariaDeDocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface FranjaHorariaMapperInfraestructuraDominio {
    FranjaHoraria mappearDePeticionAFranjaHoraria(FranjaHorariaDTOPeticion peticion);

    FranjaHorariaDTORespuesta mappearDeFranjaHorariaARespuesta(FranjaHoraria franjaHoraria);

    List<FranjaHorariaDTORespuesta> mappearDeFranjasHorariasARespuesta(List<FranjaHoraria> franjas);

    FranjaHorariaDeDocenteDTORespuesta mappearDeFranjaHorariaADocenteRespuesta(FranjaHoraria franjaHoraria);

    List<FranjaHorariaDeDocenteDTORespuesta> mappearDeFranjasHorariasADocenteRespuestas(List<FranjaHoraria> franjas);

    FranjaHorariaDeCursoDTORespuesta mappearDeFranjaHorariaACursoRespuesta(FranjaHoraria franjaHoraria);

    List<FranjaHorariaDeCursoDTORespuesta> mappearDeFranjasHorariasACursoRespuestas(List<FranjaHoraria> franjas);
}
