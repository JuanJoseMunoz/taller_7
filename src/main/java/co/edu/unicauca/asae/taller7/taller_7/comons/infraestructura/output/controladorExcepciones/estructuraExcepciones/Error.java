package co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.estructuraExcepciones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    private String codigoError;

    private String mensaje;

    private Integer codigoHttp;

    @Accessors(chain = true)
    private String url;

    @Accessors(chain = true)
    private String metodo;
}
