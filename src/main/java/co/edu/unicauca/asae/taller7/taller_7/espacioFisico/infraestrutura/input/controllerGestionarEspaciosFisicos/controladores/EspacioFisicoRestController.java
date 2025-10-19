package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.aplicacion.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.DTOPeticion.EspacioFisicoDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.DTORespuesta.EspacioFisicoDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.mappers.EspacioFisicoMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/espaciosFisicos") 
@RequiredArgsConstructor
public class EspacioFisicoRestController {
    
    private final GestionarEspacioFisicoCUIntPort objGestionarEspacioFisicoCUInt; 
    private final EspacioFisicoMapperInfraestructuraDominio objMapeador;
    
    @PostMapping("/espaciosFisicos")
    public ResponseEntity<EspacioFisicoDTORespuesta> crearEspacioFisico(@RequestBody @Valid EspacioFisicoDTOPeticion objEspacioFisicoDTOPeticion) {
        EspacioFisico objEspacioFisico = objMapeador.mappearDePeticionAEspacioFisico(objEspacioFisicoDTOPeticion);
        EspacioFisico espacioCreado = objGestionarEspacioFisicoCUInt.crearEspacioFisico(objEspacioFisico);
        ResponseEntity<EspacioFisicoDTORespuesta> objRespuesta = new ResponseEntity<EspacioFisicoDTORespuesta>(
                objMapeador.mappearDeEspacioFisicoARespuesta(espacioCreado), HttpStatus.CREATED);
        return objRespuesta;
    }
    
    @GetMapping("/espaciosFisicos")
    public ResponseEntity<List<EspacioFisicoDTORespuesta>> listarEspaciosFisicos(@RequestParam String patron, @RequestParam Integer capacidadMinima) {        
        ResponseEntity<List<EspacioFisicoDTORespuesta>> objRespuesta = new ResponseEntity<List<EspacioFisicoDTORespuesta>>(
            objMapeador.mappearDeEspacioFisicoARespuesta(objGestionarEspacioFisicoCUInt.listarEspaciosFisicos(patron, capacidadMinima)), HttpStatus.OK);
        return objRespuesta;
    }
    
    @PatchMapping("/{id}/estado")
    public ResponseEntity<?> actualizarEstadoEspacioFisico(@PathVariable Integer id, @RequestParam String estado) {
        Object resultado = objGestionarEspacioFisicoCUInt.actualizarEstadoEspacioFisico(id, estado);
        
        if (resultado instanceof ResponseEntity) {
            return (ResponseEntity<?>) resultado;
        }
        
        EspacioFisicoDTORespuesta espacioFisicoActualizado = 
            objMapeador.mappearDeEspacioFisicoARespuesta((EspacioFisico) resultado);
        
        return new ResponseEntity<>(espacioFisicoActualizado, HttpStatus.OK);
    }
}