package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.gateway;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.aplicacion.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.repositorios.EspacioFisicoRepositoryInt;
import jakarta.transaction.Transactional;

@Service
public class GestionarEspacioFisicoGatewayImplAdapter implements GestionarEspacioFisicoGatewayIntPort {
    
    private final EspacioFisicoRepositoryInt objEspacioFisicoRepository;
    private final ModelMapper espacioFisicoModelMapper; 
    
    public GestionarEspacioFisicoGatewayImplAdapter(EspacioFisicoRepositoryInt objEspacioFisicoRepository, ModelMapper espacioFisicoModelMapper) {
        this.objEspacioFisicoRepository = objEspacioFisicoRepository;
        this.espacioFisicoModelMapper = espacioFisicoModelMapper;
    }
    
    @Override
    public EspacioFisico guardarEspacioFisico(EspacioFisico objEspacioFisico) {
        EspacioFisicoEntity espacioFisicoEntity = this.espacioFisicoModelMapper.map(objEspacioFisico, EspacioFisicoEntity.class);
        EspacioFisicoEntity espacioGuardado = this.objEspacioFisicoRepository.save(espacioFisicoEntity);
        return this.espacioFisicoModelMapper.map(espacioGuardado, EspacioFisico.class);
    }
    
    @Override
    public List<EspacioFisico> listarEspaciosFisicos(String nombre, Integer capacidadMinima) {
        Iterable<EspacioFisicoEntity> listaEspaciosFisicosEntity = this.objEspacioFisicoRepository.findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombreAsc(nombre, capacidadMinima);
        List<EspacioFisico> listaEspaciosFisicos = this.espacioFisicoModelMapper.map(listaEspaciosFisicosEntity, new TypeToken<List<EspacioFisico>>() {
        }.getType());
        return listaEspaciosFisicos;
    }
    
    @Override
    public boolean existeEspacioFisico(String nombre) {
        return objEspacioFisicoRepository.existsByNombre(nombre);
    }
    
    @Override
    @Transactional 
    public EspacioFisico actualizarEstadoEspacioFisico(Integer id, String estado) {
        int bandera = this.objEspacioFisicoRepository.actualizarEstado(id, estado);
        if (bandera > 0) {
            this.objEspacioFisicoRepository.flush();
            Optional<EspacioFisicoEntity> espacioFisicoEntity = this.objEspacioFisicoRepository.findById(id);
            if (espacioFisicoEntity.isPresent()) {
                EspacioFisicoEntity objEspacioFisicoEntityActualizado = espacioFisicoEntity.get();
                EspacioFisico objEspacioFisicoRespuesta = this.espacioFisicoModelMapper.map(objEspacioFisicoEntityActualizado, EspacioFisico.class);
                return objEspacioFisicoRespuesta;
            }
        }
        return null;
    }
    
    @Override
    public EspacioFisico buscarEspacioFisicoPorId(Integer id) {
        Optional<EspacioFisicoEntity> objEspacioFisicoEntity = this.objEspacioFisicoRepository.findById(id);
        if (objEspacioFisicoEntity.isPresent()) {  
            EspacioFisicoEntity objEspacioFisicoEntityEncontrado = objEspacioFisicoEntity.get();
            EspacioFisico objEspacioFisicoRespuesta = this.espacioFisicoModelMapper.map(objEspacioFisicoEntityEncontrado, EspacioFisico.class);
            return objEspacioFisicoRespuesta;
        }
        return null;
    }
}