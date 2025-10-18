package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.getway;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.output.GestionarDocenteGetwayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.repositories.DocenteRepositoryInt;
import jakarta.transaction.Transactional;

public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGetwayIntPort {

    private final DocenteRepositoryInt objDocenteRepository;
    private final ModelMapper docenteModelMapper;

    public GestionarDocenteGatewayImplAdapter(DocenteRepositoryInt objDocenteRepository,
            ModelMapper docenteModelMapper) {
        this.objDocenteRepository = objDocenteRepository;
        this.docenteModelMapper = docenteModelMapper;
    }

    @Override
    public boolean existeDocente(Integer id) {
        return objDocenteRepository.existsById(id);
    }

    @Override
    @Transactional
    public Docente guardarDocente(Docente objDocente) {
        DocenteEntity objDocenteEntity = docenteModelMapper.map(objDocente, DocenteEntity.class);
        DocenteEntity objDocenteEntityRegistrado = this.objDocenteRepository.save(objDocenteEntity);
        Docente objDocenteRespuesta = this.docenteModelMapper.map(objDocenteEntityRegistrado, Docente.class);
        return objDocenteRespuesta;
    }

    @Override
    public Docente buscarDocentePorId(Integer id) {
        Optional<DocenteEntity> objDocenteEntity = this.objDocenteRepository.findById(id);
        if (objDocenteEntity.isEmpty()) {
            return null;
        }
        DocenteEntity objDocenteEntityEncontrado = objDocenteEntity.get();
        Docente objDocenteRespuesta = this.docenteModelMapper.map(objDocenteEntityEncontrado, Docente.class);
        return objDocenteRespuesta;
    }

    @Override
    public List<Docente> listarDocentes() {
        Iterable<DocenteEntity> lista = this.objDocenteRepository.findAll();
        List<Docente> listaDocentes = this.docenteModelMapper.map(lista, new TypeToken<List<Docente>>() {
        }.getType());
        return listaDocentes;
    }

    @Override
    @Transactional
    public Docente actualizarDocente(Docente objDocente) {
        if (objDocente.getId() == null || !objDocenteRepository.existsById(objDocente.getId())) {
            return null;
        }
        return guardarDocente(objDocente);
    }

    @Override
    @Transactional
    public Docente eliminarDocente(Integer id) {
        Optional<DocenteEntity> objDocenteEntity = this.objDocenteRepository.findById(id);
        if (objDocenteEntity.isEmpty()) {
            return null;
        }
        DocenteEntity objDocenteEntityAEliminar = objDocenteEntity.get();
        this.objDocenteRepository.delete(objDocenteEntityAEliminar);
        Docente objDocenteRespuesta = this.docenteModelMapper.map(objDocenteEntityAEliminar, Docente.class);
        return objDocenteRespuesta;
    }
}