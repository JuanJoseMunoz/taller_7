package co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.excepcionesPropias;

import co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;

public class ReglaNegocioExcepcion extends GestionFranjasHorariasRuntimeException {
    private static final String FORMATO_EXCEPCION = "%s - Violación a regla de negocio: %s";

    private final String reglaNegocio;

    public ReglaNegocioExcepcion(final String reglaNegocio) {
        super(CodigoError.VIOLACION_REGLA_DE_NEGOCIO);
        this.reglaNegocio = reglaNegocio;
    }

    @Override
    public String formatException() {
        return String.format(FORMATO_EXCEPCION, codigoError.getCodigo(), reglaNegocio);
    }

}
