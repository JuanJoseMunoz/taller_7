package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.controladorExcepciones.estructuraExcepciones;

public final class ErrorUtils {

    ErrorUtils() {

    }

    public static Error crearError(final String codigoError, final String llaveMensaje, final Integer codigoHttp) {
        final Error error = new Error();
        error.setCodigoError(codigoError);
        error.setMensaje(llaveMensaje);
        error.setCodigoHttp(codigoHttp);
        return error;
    }
}
