package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos;

import java.util.HashSet;
import java.util.Set;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Curso {
    private Integer id;
    private String nombre;
    private Integer matriculaEstimada;
    private Asignatura objAsignatura;
     private Set<Docente> docentes = new HashSet<>();
}
