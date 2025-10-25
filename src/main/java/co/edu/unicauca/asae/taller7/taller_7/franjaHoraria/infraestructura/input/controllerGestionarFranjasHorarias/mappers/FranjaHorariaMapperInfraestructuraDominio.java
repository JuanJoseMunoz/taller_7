package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.mappers;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.CursoDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.EspacioFisicoDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.FranjaHorariaDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.FranjaHorariaDeCursoDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.FranjaHorariaDeDocenteDTORespuesta;

@Component
public class FranjaHorariaMapperInfraestructuraDominio {

    // De peticion a dominio
    public FranjaHoraria mappearDePeticionAFranjaHoraria(FranjaHorariaDTOPeticion franja) {
        FranjaHoraria franjaHoraria = new FranjaHoraria();
        franjaHoraria.setDia(String.valueOf(franja.getDia()));
        franjaHoraria.setHoraInicio(LocalTime.parse(franja.getHoraInicio()));
        franjaHoraria.setHoraFin(LocalTime.parse(franja.getHoraFin()));

        Curso curso = new Curso();
        curso.setId(franja.getIdCurso());
        franjaHoraria.setObjCurso(curso);

        EspacioFisico espacioFisico = new EspacioFisico();
        espacioFisico.setId(franja.getIdEspacioFisico());
        franjaHoraria.setObjEspacioFisico(espacioFisico);
        return franjaHoraria;
    }

    // De dominio a respuesta
    public FranjaHorariaDTORespuesta mappearDeFranjaHorariaARespuesta(FranjaHoraria franja) {
        FranjaHorariaDTORespuesta franjaDTO = new FranjaHorariaDTORespuesta();
        franjaDTO.setId(franja.getId());
        franjaDTO.setDia(franja.getDia());
        franjaDTO.setHoraInicio(franja.getHoraInicio());
        franjaDTO.setHoraFin(franja.getHoraFin());
        franjaDTO.setCursoId(franja.getObjCurso().getId());
        franjaDTO.setEspacioFisicoId(franja.getObjEspacioFisico().getId());
        return franjaDTO;
    }

    // De dominio a respuesta de docente
    public FranjaHorariaDeDocenteDTORespuesta mappearDeFranjaHorariaADocenteRespuesta(FranjaHoraria franja) {
        FranjaHorariaDeDocenteDTORespuesta franjaDTO = new FranjaHorariaDeDocenteDTORespuesta();
        franjaDTO.setId(franja.getId());
        franjaDTO.setDia(franja.getDia());
        franjaDTO.setHoraInicio(franja.getHoraInicio());
        franjaDTO.setHoraFin(franja.getHoraFin());

        if (franja.getObjCurso() != null) {
            Curso curso = franja.getObjCurso();
            CursoDTORespuesta cursoDTO = new CursoDTORespuesta();
            cursoDTO.setId(curso.getId());
            cursoDTO.setNombre(curso.getNombre());
            cursoDTO.setDocentes(mappearDocentes(franja.getObjCurso().getDocentes()));
            franjaDTO.setCurso(cursoDTO);
        }

        if (franja.getObjEspacioFisico() != null) {
            franjaDTO.setEspacioFisico(mappearEspacioFisico(franja.getObjEspacioFisico()));
        }
        return franjaDTO;
    }

    // De dominio a respuesta de curso
    public FranjaHorariaDeCursoDTORespuesta mappearDeFranjaHorariaACursoRespuesta(FranjaHoraria franja) {
        FranjaHorariaDeCursoDTORespuesta franjaDTO = new FranjaHorariaDeCursoDTORespuesta();
        franjaDTO.setId(franja.getId());
        franjaDTO.setDia(franja.getDia());
        franjaDTO.setHoraInicio(franja.getHoraInicio());
        franjaDTO.setHoraFin(franja.getHoraFin());

        if (franja.getObjEspacioFisico() != null) {
            franjaDTO.setEspacioFisico(mappearEspacioFisico(franja.getObjEspacioFisico()));
        }

        if (franja.getObjCurso() != null && franja.getObjCurso().getDocentes() != null) {
            franjaDTO.setDocentes(mappearDocentes(franja.getObjCurso().getDocentes()));
        }

        return franjaDTO;
    }

    // De dominio a lista de respuesta de docente
    public List<FranjaHorariaDeDocenteDTORespuesta> mappearListaDeFranjaHorariaADocenteRespuesta(
            List<FranjaHoraria> franjas) {
        return franjas.stream()
                .map(this::mappearDeFranjaHorariaADocenteRespuesta)
                .collect(Collectors.toList());
    }

    // De dominio a lista de respuesta de curso
    public List<FranjaHorariaDeCursoDTORespuesta> mappearListaDeFranjaHorariaACursoRespuesta(
            List<FranjaHoraria> franjas) {
        return franjas.stream()
                .map(this::mappearDeFranjaHorariaACursoRespuesta)
                .collect(Collectors.toList());
    }

    private EspacioFisicoDTORespuesta mappearEspacioFisico(EspacioFisico espacio) {
        EspacioFisicoDTORespuesta dto = new EspacioFisicoDTORespuesta();
        dto.setId(espacio.getId());
        dto.setNombre(espacio.getNombre());
        dto.setCapacidad(espacio.getCapacidad());
        dto.setEstado(espacio.getEstado());
        return dto;
    }

    public List<CursoDTORespuesta> mappearCurso(List<Curso> cursos) {
        return cursos.stream()
                .map(this::mappearCursoRespuesta)
                .collect(Collectors.toList());
        
    }

    private CursoDTORespuesta mappearCursoRespuesta(Curso curso) {
        CursoDTORespuesta dto = new CursoDTORespuesta();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setDocentes(curso.getDocentes().stream()
                .map(this::mappearDocente)
                .collect(Collectors.toSet()));
        return dto;
    }


    private Set<DocenteDTORespuesta> mappearDocentes(Set<Docente> docentes) {
        return docentes.stream()
                .map(this::mappearDocente)
                .collect(Collectors.toSet());
    }

    private DocenteDTORespuesta mappearDocente(Docente docente) {
        DocenteDTORespuesta dto = new DocenteDTORespuesta();
        dto.setId(docente.getId());
        dto.setNombre(docente.getNombre());
        dto.setApellido(docente.getApellido());
        dto.setCorreo(docente.getCorreo());
        return dto;
    }

}