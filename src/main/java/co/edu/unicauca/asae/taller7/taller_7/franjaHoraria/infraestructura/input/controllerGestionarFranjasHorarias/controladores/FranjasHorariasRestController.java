package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena.Orquestadorvalidaciones;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.FranjaHorariaDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.FranjaHorariaDeCursoDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.FranjaHorariaDeDocenteDTORespuesta;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.mappers.FranjaHorariaMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FranjasHorariasRestController {
    private final GestionarFranjaHorariaCUIntPort objGestionarFranjaHorariaCUInt;
    private final FranjaHorariaMapperInfraestructuraDominio objMapeador;
    private final Orquestadorvalidaciones  objOrquestadorValidaciones;

    @PostMapping("/franjasHorarias")
    public ResponseEntity<FranjaHorariaDTORespuesta> crearFranjaHoraria(
            @Valid @RequestBody FranjaHorariaDTOPeticion objFranjaHoraria) {
        objOrquestadorValidaciones.ejecutarValidacionesFranjaHoraria(objFranjaHoraria);
        FranjaHoraria objFranjaHorariaCrear = objMapeador.mappearDePeticionAFranjaHoraria(objFranjaHoraria);
        FranjaHoraria objFranjaHorariaCreada = objGestionarFranjaHorariaCUInt.crearFranjaHoraria(objFranjaHorariaCrear);
        ResponseEntity<FranjaHorariaDTORespuesta> objRespuesta = new ResponseEntity<FranjaHorariaDTORespuesta>(
                objMapeador.mappearDeFranjaHorariaARespuesta(objFranjaHorariaCreada), HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/franjasHorarias/curso/{idCurso}")
    public ResponseEntity<List<FranjaHorariaDeCursoDTORespuesta>> listarFranjasPorCurso(@PathVariable Integer idCurso) {
        List<FranjaHoraria> franjas = objGestionarFranjaHorariaCUInt.listarFranjasPorCurso(idCurso);
        ResponseEntity<List<FranjaHorariaDeCursoDTORespuesta>> objRespuesta = new ResponseEntity<List<FranjaHorariaDeCursoDTORespuesta>>(
                objMapeador.mappearDeFranjasHorariasACursoRespuestas(franjas), HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/franjasHorarias/docente/{idDocente}")
    public ResponseEntity<List<FranjaHorariaDeDocenteDTORespuesta>> listarFranjasPorDocente(
            @PathVariable @Min(value = 1, message = "{docente.id.min}") Integer idDocente) {
        List<FranjaHoraria> franjas = objGestionarFranjaHorariaCUInt.listarFranjasPorDocente(idDocente);
        ResponseEntity<List<FranjaHorariaDeDocenteDTORespuesta>> objRespuesta = new ResponseEntity<List<FranjaHorariaDeDocenteDTORespuesta>>(
                objMapeador.mappearDeFranjasHorariasADocenteRespuestas(franjas), HttpStatus.OK);
        return objRespuesta;
    }

}
