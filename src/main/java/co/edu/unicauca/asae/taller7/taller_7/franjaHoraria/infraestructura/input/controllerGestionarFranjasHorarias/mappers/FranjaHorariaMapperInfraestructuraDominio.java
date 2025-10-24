package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;
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
    @Mapping(source = "docentesIds", target = "objCurso.listaDocentes")

    FranjaHoraria mappearDePeticionAFranjaHoraria(FranjaHorariaDTOPeticion peticion);

    @Mapping(source = "objEspacioFisico.id", target = "espacioFisico")
    @Mapping(source = "objCurso.idCurso", target = "curso")
    @Mapping(source = "objCurso.listaDocentes", target = "docentesIds")
    FranjaHorariaDTORespuesta mappearDeFranjaHorariaARespuesta(FranjaHoraria franjaHoraria);

    List<FranjaHorariaDTORespuesta> mappearDeFranjasHorariasARespuesta(List<FranjaHoraria> franjas);

    default List<Docente> map(List<Integer> ids) {
        if (ids == null)
            return null;
        return ids.stream()
                .map(id -> {
                    Docente d = new Docente();
                    d.setId(id);
                    return d;
                })
                .collect(Collectors.toList());
    }

    default List<Integer> mapDocentesAIds(List<Docente> docentes) {
        if (docentes == null)
            return null;
        return docentes.stream()
                .map(Docente::getId)
                .collect(Collectors.toList());
    }

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
