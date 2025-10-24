package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.repositorios.EspacioFisicoRepositoryInt;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios.CursoRepositoryInt;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.repositorios.FranjaHorariaRepositoryInt;
import jakarta.transaction.Transactional;

@Service
public class GestionarFranjaHorariaGatewayImplAdapter implements GestionarFranjaHorariaGatewayIntPort {
    private final FranjaHorariaRepositoryInt objFranjaHorariaRepository;
    private final CursoRepositoryInt objCursoRepository;
    private final ModelMapper franjaHorariaModelMapper;

    public GestionarFranjaHorariaGatewayImplAdapter(FranjaHorariaRepositoryInt objFranjaHorariaRepository,
            CursoRepositoryInt objCursoRepository,
            EspacioFisicoRepositoryInt objEspacioFisicoRepository,
            ModelMapper franjaHorariaModelMapper) {
        this.objFranjaHorariaRepository = objFranjaHorariaRepository;
        this.objCursoRepository = objCursoRepository;
        this.franjaHorariaModelMapper = franjaHorariaModelMapper;
    }

    @Override
    @Transactional
    public FranjaHoraria guardarFranjaHoraria(FranjaHoraria objFranjaHoraria) {
        FranjaHorariaEntity objFranjaHorariaEntity = this.franjaHorariaModelMapper.map(objFranjaHoraria,
                FranjaHorariaEntity.class);
        FranjaHorariaEntity objFranjaHorariaEntityRegistrado = this.objFranjaHorariaRepository
                .save(objFranjaHorariaEntity);
        FranjaHoraria objFranjaHorariaRespuesta = this.franjaHorariaModelMapper.map(objFranjaHorariaEntityRegistrado,
                FranjaHoraria.class);
        return objFranjaHorariaRespuesta;
    }

    @Override
    public List<FranjaHoraria> listarFranjasPorCurso(Integer idCurso) {
        List<FranjaHorariaEntity> lista = this.objFranjaHorariaRepository.findByObjCursoIdCurso(idCurso);
        List<FranjaHoraria> listaFranjas = this.franjaHorariaModelMapper.map(lista,
                new TypeToken<List<FranjaHoraria>>() {
                }.getType());
        return listaFranjas;
    }

    @Override
    public List<FranjaHoraria> listarFranjasPorDocente(Integer idDocente) {
        List<FranjaHorariaEntity> lista = this.objFranjaHorariaRepository.findByDocenteId(idDocente);
        List<FranjaHoraria> listaFranjas = this.franjaHorariaModelMapper.map(lista,
                new TypeToken<List<FranjaHoraria>>() {
                }.getType());
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
}
