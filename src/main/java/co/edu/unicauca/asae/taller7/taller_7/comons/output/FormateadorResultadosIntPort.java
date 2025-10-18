package co.edu.unicauca.asae.taller7.taller_7.comons.output;

public interface FormateadorResultadosIntPort {
    public void retornarRespuestaErrorEntidadExiste(String mensaje);

    public void retornarRespuestaErrorEntidadNoExiste(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
