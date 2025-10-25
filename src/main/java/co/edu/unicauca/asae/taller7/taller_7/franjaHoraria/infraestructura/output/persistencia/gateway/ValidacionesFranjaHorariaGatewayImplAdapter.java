package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.repositories.DocenteRepositoryInt;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.repositorios.EspacioFisicoRepositoryInt;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.ValidacionesGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios.CursoRepositoryInt;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios.FranjaHorariaRepositoryInt;

public class ValidacionesFranjaHorariaGatewayImplAdapter implements ValidacionesGatewayIntPort {

    @Qualifier("IDEspacioFisicoRepository")
    private final EspacioFisicoRepositoryInt espacioFisicoRepository;
    
    @Qualifier("IDDocenteRepository")
    private final DocenteRepositoryInt docenteRepository;
    
    @Qualifier("IDCursoRepository")
    private final CursoRepositoryInt cursoRepository;
    
    @Qualifier("IDFranjaHorariaRepository")
    private final FranjaHorariaRepositoryInt franjaHorariaRepository;

    public ValidacionesFranjaHorariaGatewayImplAdapter(EspacioFisicoRepositoryInt espacioFisicoRepository,
                                        DocenteRepositoryInt docenteRepository,
                                        CursoRepositoryInt cursoRepository,
                                        FranjaHorariaRepositoryInt franjaHorariaRepository) {
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.docenteRepository = docenteRepository;
        this.cursoRepository = cursoRepository;
        this.franjaHorariaRepository = franjaHorariaRepository;
    }

    @Override
    public boolean isEspacioFisicoOcupado(Integer idEspacioFisico, String dia, LocalTime horaInicio, LocalTime horaFin) {
        return franjaHorariaRepository.isEspacioFisicoOcupado(idEspacioFisico, dia, horaInicio, horaFin);
    }

    @Override
    public int isDocenteOcupado(Integer idDocente, String dia, LocalTime horaInicio, LocalTime horaFin) {
        return franjaHorariaRepository.isDocenteOcupado(idDocente, dia, horaInicio, horaFin);
    }

    @Override
    public boolean existeEspacioFisico(Integer idEspacioFisico) {
        return espacioFisicoRepository.existsById(idEspacioFisico);
    }

    @Override
    public boolean existeDocente(Integer idDocente) {
        return docenteRepository.existsById(idDocente);
    }

    @Override
    public boolean existeCurso(Integer idCurso) {
        return cursoRepository.existsById(idCurso);
    }

    @Override
    public boolean existeDocenteByCorreo(String correo) {   
        return docenteRepository.existsByCorreo(correo);
    }

    public Set<Docente> obtenerDocentesDeCurso(int cursoId) {
        CursoEntity cursoEntity = cursoRepository.findById(cursoId)
            .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + cursoId));

        if (cursoEntity.getListaDocentes() == null || cursoEntity.getListaDocentes().isEmpty()) {
            return Set.of();
        }

        Set<Docente> docentes = cursoEntity.getListaDocentes().stream()
                .map(this::mappearDocenteEntityADominio)
                .collect(Collectors.toSet());
        return docentes;
    }

    private Docente mappearDocenteEntityADominio(DocenteEntity entity) {
        Docente docente = new Docente();
        docente.setId(entity.getId());
        docente.setNombre(entity.getNombre());
        docente.setApellido(entity.getApellido());
        docente.setCorreo(entity.getCorreo());
        return docente;
    }

}
