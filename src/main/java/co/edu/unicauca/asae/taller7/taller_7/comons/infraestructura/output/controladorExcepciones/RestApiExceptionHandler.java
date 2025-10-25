package co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.estructuraExcepciones.ErrorUtils;
import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import jakarta.servlet.http.HttpServletRequest;
import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.estructuraExcepciones.Error;

@ControllerAdvice
public class RestApiExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req, final Exception ex,
                        final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ERROR_GENERICO.getCodigo(),
                                                CodigoError.ERROR_GENERICO.getLlaveMensaje(),
                                                HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(ReglaNegocioExcepcion.class)
        public ResponseEntity<Error> handleReglaNegocioException(final HttpServletRequest req, ReglaNegocioExcepcion ex,
                        Locale locale) {
                Error error = ErrorUtils.crearError(ex.getCodigoError().getCodigo(),
                                ex.formatException(), HttpStatus.BAD_REQUEST.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(EntidadNoExisteException.class)
        public ResponseEntity<Error> handleEntidadNoExisteException(final HttpServletRequest req,
                        EntidadNoExisteException ex, Locale locale) {
                Error error = ErrorUtils.crearError(ex.getCodigo(), ex.getMessage(),
                                HttpStatus.NOT_FOUND.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(EntidadYaExisteException.class)
        public ResponseEntity<Error> handleEntidadYaExisteException(final HttpServletRequest req,
                        EntidadYaExisteException ex, Locale locale) {
                Error error = ErrorUtils.crearError(ex.getCodigo(), ex.getMessage(),
                                HttpStatus.CONFLICT.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Error> handleMethodArgumentNotValidException(final HttpServletRequest req,
                        MethodArgumentNotValidException ex, Locale locale) {
                String defaultMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
                CodigoError codigoError = defaultMessage.contains("capacidad") ? 
                        CodigoError.CAPACIDAD_INSUFICIENTE : CodigoError.VALIDACION_FALLIDA;
                Error error = ErrorUtils.crearError(codigoError.getCodigo(), defaultMessage,
                                HttpStatus.BAD_REQUEST.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

}
