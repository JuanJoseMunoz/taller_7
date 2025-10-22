package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Curso {
    private Integer idCurso;
    private String nombre;
    private Integer matriculaEstimada;
    private List<FranjaHoraria> franjasHorarias;
    private Asignatura objAsignatura;
    private List<Docente> listaDocentes;

    public Curso() {
    }
}
