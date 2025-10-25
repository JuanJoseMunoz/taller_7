package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.validacionesCadena.Orquestadorvalidaciones;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.DTORespuesta.CursoDTORespuesta;
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
        FranjaHorariaDTORespuesta objRespuesta = objMapeador.mappearDeFranjaHorariaARespuesta(objFranjaHorariaCreada);
        return new ResponseEntity<>(objRespuesta, HttpStatus.CREATED);
    }

    @GetMapping("/franjasHorarias/curso/{idCurso}")
    public ResponseEntity<List<FranjaHorariaDeCursoDTORespuesta>> listarFranjasPorCurso(@PathVariable Integer idCurso) {
        List<FranjaHoraria> franjas = objGestionarFranjaHorariaCUInt.listarFranjasPorCurso(idCurso);
        List<FranjaHorariaDeCursoDTORespuesta> franjasDTO = objMapeador
                .mappearListaDeFranjaHorariaACursoRespuesta(franjas);
        return new ResponseEntity<>(franjasDTO, HttpStatus.OK);
    }

    @GetMapping("/franjasHorarias/docente/{idDocente}")
    public ResponseEntity<List<FranjaHorariaDeDocenteDTORespuesta>> listarFranjasPorDocente(
            @PathVariable @Min(value = 1, message = "{docente.id.min}") Integer idDocente) {
        List<FranjaHoraria> franjas = objGestionarFranjaHorariaCUInt.listarFranjasPorDocente(idDocente);
        List<FranjaHorariaDeDocenteDTORespuesta> franjasDTO = objMapeador
                .mappearListaDeFranjaHorariaADocenteRespuesta(franjas);
        return new ResponseEntity<>(franjasDTO, HttpStatus.OK);
    }

    @GetMapping("/franjasHorariasDetalleCurso/{cursoId}")
    public ResponseEntity<List<Object[]>> obtenerDetalleFranjasCurso(@PathVariable @Min(value = 1, message = "{franjaHoraria.cursoId.min}") int cursoId) {
        List<Object[]> detalle = objGestionarFranjaHorariaCUInt.obtenerDetalleFranjasCurso(cursoId);
        return new ResponseEntity<>(detalle, HttpStatus.OK);
    }

    @DeleteMapping("/franjasHorarias/curso/{cursoId}")
    public ResponseEntity<String> eliminarFranjasPorCurso(@PathVariable @Min(value = 1, message = "{franjaHoraria.cursoId.min}") int cursoId) {
        int eliminadas = objGestionarFranjaHorariaCUInt.eliminarFranjasPorCurso(cursoId);
        String mensaje = String.format("Se eliminaron %d franja(s) horaria(s) del curso", eliminadas);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping("/curso/{nomAsignatura}")
    public ResponseEntity<List<CursoDTORespuesta>> listarCursosByAsig(@PathVariable String nomAsignatura) {
        List<Curso> cursos = objGestionarFranjaHorariaCUInt.listarCursosPorAsignatura(nomAsignatura);
        List<CursoDTORespuesta> CursosDTO = objMapeador
                .mappearCurso(cursos);
        return new ResponseEntity<>(CursosDTO, HttpStatus.OK);
    }
}
