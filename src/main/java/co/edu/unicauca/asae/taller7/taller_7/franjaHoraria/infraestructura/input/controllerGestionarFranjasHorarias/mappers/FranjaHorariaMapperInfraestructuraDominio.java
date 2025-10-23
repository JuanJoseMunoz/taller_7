package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.FranjaHorariaDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.FranjaHorariaDeCursoDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.FranjaHorariaDeDocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface FranjaHorariaMapperInfraestructuraDominio {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "objCurso.idCurso", source = "idCurso")
    @Mapping(target = "objEspacioFisico.id", source = "idEspacioFisico")
    FranjaHoraria mappearDePeticionAFranjaHoraria(FranjaHorariaDTOPeticion peticion);

    @Mapping(source = "objEspacioFisico", target = "nombreEspacioFisico")
    @Mapping(source = "objCurso", target = "curso")
    @Mapping(source = "objCurso.listaDocentes", target = "docentes")
    @Mapping(source = "objEspacioFisico", target = "espacioFisico")
    FranjaHorariaDTORespuesta mappearDeFranjaHorariaARespuesta(FranjaHoraria franjaHoraria);

    List<FranjaHorariaDTORespuesta> mappearDeFranjasHorariasARespuesta(List<FranjaHoraria> franjas);

    @Mapping(source = "objEspacioFisico.nombre", target = "nombreEspacioFisico")
    @Mapping(source = "objEspacioFisico.capacidad", target = "capacidadEspacioFisico")
    @Mapping(source = "objCurso.nombre", target = "nombreCurso")
    @Mapping(source = "objCurso.objAsignatura.nombre", target = "nombreAsignatura")
    FranjaHorariaDeDocenteDTORespuesta mappearDeFranjaHorariaADocenteRespuesta(FranjaHoraria franjaHoraria);

    List<FranjaHorariaDeDocenteDTORespuesta> mappearDeFranjasHorariasADocenteRespuestas(List<FranjaHoraria> franjas);

    @Mapping(source = "objEspacioFisico.nombre", target = "nombreEspacioFisico")
    @Mapping(source = "objEspacioFisico.capacidad", target = "capacidadEspacioFisico")
    @Mapping(target = "nombresDocentes", ignore = true)
    FranjaHorariaDeCursoDTORespuesta mappearDeFranjaHorariaACursoRespuesta(FranjaHoraria franjaHoraria);

    List<FranjaHorariaDeCursoDTORespuesta> mappearDeFranjasHorariasACursoRespuestas(List<FranjaHoraria> franjas);
}
