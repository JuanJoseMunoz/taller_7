package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.casosDeUso;

import co.edu.unicauca.asae.taller7.taller_7.comons.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;

public class GestionarFranjaHorariaCUAdapter {
    
    private final GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway;
    private final FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados;

    public GestionarFranjaHorariaCUAdapter(GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
        this.objGestionarFranjaHorariaGateway = objGestionarFranjaHorariaGateway;
        this.objFranjaHorariaFormateadorResultados = objFranjaHorariaFormateadorResultados;
    }   
}
