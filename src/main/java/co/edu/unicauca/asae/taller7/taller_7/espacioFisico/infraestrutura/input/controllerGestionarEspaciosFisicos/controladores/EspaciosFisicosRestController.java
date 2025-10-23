package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.controladores;

import java.time.LocalTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.DTOPeticion.EspacioFisicoDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.DTORespuesta.EspacioFisicoDTORespuesta;
import jakarta.validation.Valid;

import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.aplicacion.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.input.controllerGestionarEspaciosFisicos.mappers.EspacioFisicoMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EspaciosFisicosRestController {
    
    private final GestionarEspacioFisicoCUIntPort objGestionarEspacioFisicoCUInt;
    private final EspacioFisicoMapperInfraestructuraDominio objMapeador;

    @PostMapping("/espaciosFisicos")
    public ResponseEntity<EspacioFisicoDTORespuesta> crear(@RequestBody @Valid EspacioFisicoDTOPeticion objEspacioFisico) {
        EspacioFisico espacioFisicoCrear = objMapeador.mappearDePeticionAEspacioFisico(objEspacioFisico);
        EspacioFisico espacioFisicoCreado = objGestionarEspacioFisicoCUInt.crear(espacioFisicoCrear);
        ResponseEntity<EspacioFisicoDTORespuesta> objRespuesta = new ResponseEntity<EspacioFisicoDTORespuesta>(
                objMapeador.mappearDeEspacioFisicoARespuesta(espacioFisicoCreado), HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/espaciosFisicos")
    public ResponseEntity<List<EspacioFisicoDTORespuesta>> listar(
            @RequestParam(required = false) String patron,
            @RequestParam(required = false) Integer capacidadMinima) {
        ResponseEntity<List<EspacioFisicoDTORespuesta>> objRespuesta = new ResponseEntity<List<EspacioFisicoDTORespuesta>>(
                objMapeador.mappearDeEspaciosFisicosARespuesta(objGestionarEspacioFisicoCUInt.listar(patron, capacidadMinima)), HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/espaciosFisicos/{id}")
    public ResponseEntity<EspacioFisicoDTORespuesta> buscarById(@PathVariable Integer id) {
        EspacioFisico espacioFisico = objGestionarEspacioFisicoCUInt.buscarById(id);
        ResponseEntity<EspacioFisicoDTORespuesta> objRespuesta = new ResponseEntity<EspacioFisicoDTORespuesta>(
                objMapeador.mappearDeEspacioFisicoARespuesta(espacioFisico),
                HttpStatus.OK);
        return objRespuesta;
    }

    @PutMapping("/espaciosFisicos/{id}/estado")
    public ResponseEntity<Object> actualizarEstado(@PathVariable Integer id, @RequestParam String estado) {
        Object resultado = objGestionarEspacioFisicoCUInt.actualizarEstado(id, estado);
        ResponseEntity<Object> objRespuesta = new ResponseEntity<Object>(resultado, HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/espaciosFisicos/{id}/ocupado")
    public ResponseEntity<Boolean> estaOcupado(@PathVariable Integer id,
            @RequestParam String dia,
            @RequestParam LocalTime horaInicio,
            @RequestParam LocalTime horaFin) {
        //LocalTime inicio = LocalTime.parse(horaInicio);
        //LocalTime fin = LocalTime.parse(horaFin);
        boolean ocupado = objGestionarEspacioFisicoCUInt.estaOcupado(id, dia, horaInicio, horaFin);
        ResponseEntity<Boolean> objRespuesta = new ResponseEntity<Boolean>(ocupado, HttpStatus.OK);
        return objRespuesta;
    }
}
