package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller7.taller_7.docente.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.input.controllerGestionarDocentes.mappers.DocenteMapperInfraestructuraDominio;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena.Orquestadorvalidaciones;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DocentesRestController {
 
    private final GestionarDocenteCUIntPort objGestionarDocenteCUInt;
    private final DocenteMapperInfraestructuraDominio objMapeador;
    private final Orquestadorvalidaciones orquestadorValidaciones;

    @PostMapping("/docentes")
    public ResponseEntity<DocenteDTORespuesta> crear(@RequestBody @Valid DocenteDTOPeticion objDocente) {
        orquestadorValidaciones.ejecutarValidacionesDocente(objDocente);
        Docente docenteCrear = objMapeador.mappearDePeticionADocente(objDocente);
        Docente docenteCreado = objGestionarDocenteCUInt.crearDocente(docenteCrear);
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(
                objMapeador.mappearDeDocenteARespuesta(docenteCreado), HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/docentes")
    public ResponseEntity<List<DocenteDTORespuesta>> listar() {
        ResponseEntity<List<DocenteDTORespuesta>> objRespuesta = new ResponseEntity<List<DocenteDTORespuesta>>(
                objMapeador.mappearDeDocentesARespuesta(objGestionarDocenteCUInt.listarDocentes()), HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/docentes/{id}")
    public ResponseEntity<DocenteDTORespuesta> buscarById(@PathVariable Integer id) {
        Docente docente = objGestionarDocenteCUInt.buscarDocentePorId(id);
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(
                objMapeador.mappearDeDocenteARespuesta(docente),
                HttpStatus.OK);
        return objRespuesta;
    }

    @PutMapping("/docentes/{id}")
    public ResponseEntity<DocenteDTORespuesta> actualizar(@PathVariable Integer id, @RequestBody @Valid DocenteDTOPeticion peticion) {
        Docente docenteActualizar = objMapeador.mappearDePeticionADocente(peticion);
        docenteActualizar.setId(id);
        Docente docenteActualizado = objGestionarDocenteCUInt.actualizarDocente(docenteActualizar);
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(
                objMapeador.mappearDeDocenteARespuesta(docenteActualizado),
                HttpStatus.OK);
        return objRespuesta;
    }

    @DeleteMapping("/docentes/{id}")
    public ResponseEntity<DocenteDTORespuesta> eliminar(@PathVariable Integer id) {
        Docente docenteEliminado = objGestionarDocenteCUInt.eliminarDocente(id);
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(
                objMapeador.mappearDeDocenteARespuesta(docenteEliminado),
                HttpStatus.OK);
        return objRespuesta;
    }
}
