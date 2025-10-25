package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.repositorios.EspacioFisicoRepositoryInt;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios.CursoRepositoryInt;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios.FranjaHorariaRepositoryInt;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GestionarFranjaHorariaGatewayImplAdapter implements GestionarFranjaHorariaGatewayIntPort {
    private final FranjaHorariaRepositoryInt objFranjaHorariaRepository;
    private final CursoRepositoryInt objCursoRepository;
    private final EspacioFisicoRepositoryInt objEspacioFisicoRepository;

    @Override
    @Transactional
    public FranjaHoraria guardarFranjaHoraria(FranjaHoraria objFranjaHoraria) {
        FranjaHorariaEntity franjaEntity = new FranjaHorariaEntity();
        franjaEntity.setDia(objFranjaHoraria.getDia());
        franjaEntity.setHoraInicio(objFranjaHoraria.getHoraInicio());
        franjaEntity.setHoraFin(objFranjaHoraria.getHoraFin());

        // Asociar curso
        if (objFranjaHoraria.getObjCurso() != null && objFranjaHoraria.getObjCurso().getId() > 0) {
            int cursoId = objFranjaHoraria.getObjCurso().getId();
            franjaEntity.setObjCurso(objCursoRepository.getReferenceById(cursoId));
        }

        // Asociar espacio físico
        if (objFranjaHoraria.getObjEspacioFisico() != null && objFranjaHoraria.getObjEspacioFisico().getId() > 0) {
            int espacioId = objFranjaHoraria.getObjEspacioFisico().getId();
            franjaEntity.setObjEspacioFisico(objEspacioFisicoRepository.getReferenceById(espacioId));
        }

        // Guardar la franja
        FranjaHorariaEntity franjaGuardada = objFranjaHorariaRepository.save(franjaEntity);

        // Mapear entidad guardada -> dominio
        FranjaHoraria respuesta = new FranjaHoraria();
        respuesta.setId(franjaGuardada.getId());
        respuesta.setDia(franjaGuardada.getDia());
        respuesta.setHoraInicio(franjaGuardada.getHoraInicio());
        respuesta.setHoraFin(franjaGuardada.getHoraFin());

        var curso = new Curso();
        curso.setId(franjaGuardada.getObjCurso().getIdCurso());
        respuesta.setObjCurso(curso);

        var espacio = new EspacioFisico();
        espacio.setId(franjaGuardada.getObjEspacioFisico().getId());
        respuesta.setObjEspacioFisico(espacio);

        return respuesta;
    }

    @Override
    public List<FranjaHoraria> listarFranjasPorCurso(Integer idCurso) {
        List<FranjaHorariaEntity> franjaEntity = this.objFranjaHorariaRepository.findByObjCursoIdCurso(idCurso);
        List<FranjaHoraria> listaFranjas = franjaEntity.stream()
                .map(this::mappearEntityCompletaADominio)
                .collect(Collectors.toList());
        return listaFranjas;
    }

    @Override
    public List<FranjaHoraria> listarFranjasPorDocente(Integer idDocente) {
        List<FranjaHorariaEntity> franjaEntity = this.objFranjaHorariaRepository.findByDocenteId(idDocente);
        List<FranjaHoraria> listaFranjas = franjaEntity.stream()
                .map(this::mappearEntityCompletaADominio)
                .collect(Collectors.toList());
        return listaFranjas;
    }

    @Override
    public boolean existeCurso(Integer idCurso) {
        return objCursoRepository.existsById(idCurso);
    }

    @Override
    @Transactional
    public int eliminarFranjasPorCurso(Integer idCurso) {
        return objFranjaHorariaRepository.eliminarFranjasByCurso(idCurso);
    }

    private FranjaHoraria mappearEntityCompletaADominio(FranjaHorariaEntity entity) {

        FranjaHoraria franja = new FranjaHoraria();
        franja.setId(entity.getId());
        franja.setDia(entity.getDia().toString());
        franja.setHoraInicio(entity.getHoraInicio());
        franja.setHoraFin(entity.getHoraFin());

        if (entity.getObjCurso() != null) {
            franja.setObjCurso(mappearCursoEntityADominio(entity.getObjCurso()));
        }

        if (entity.getObjEspacioFisico() != null) {
            franja.setObjEspacioFisico(mappearEspacioEntityADominio(entity.getObjEspacioFisico()));
        }

        return franja;
    }

    private Curso mappearCursoEntityADominio(CursoEntity entity) {
        Curso curso = new Curso();
        curso.setId(entity.getIdCurso());
        curso.setNombre(entity.getNombre());
        curso.setMatriculaEstimada(entity.getMatriculaEstimada());
        if (entity.getListaDocentes() != null && !entity.getListaDocentes().isEmpty()) {
            curso.setDocentes(
                    entity.getListaDocentes().stream()
                            .map(this::mappearDocenteEntityADominio)
                            .collect(Collectors.toSet()));
        }
        return curso;
    }


    private Docente mappearDocenteEntityADominio(DocenteEntity entity) {
        Docente docente = new Docente();
        docente.setId(entity.getId());
        docente.setNombre(entity.getNombre());
        docente.setApellido(entity.getApellido());
        docente.setCorreo(entity.getCorreo());
        return docente;
    }


    private EspacioFisico mappearEspacioEntityADominio(EspacioFisicoEntity entity) {
        EspacioFisico espacio = new EspacioFisico();
        espacio.setId(entity.getId());
        espacio.setNombre(entity.getNombre());
        espacio.setCapacidad(entity.getCapacidad());
        espacio.setEstado(entity.getEstado());
        ;
        return espacio;
    }
}
