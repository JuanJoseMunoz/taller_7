package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "asignaturas")
public class AsignaturaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 255)
    private String nombre;

    @Column(unique = true, nullable = false, length = 50)
    private String codigo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objAsignatura")
    private List<CursoEntity> cursos;
 
    public AsignaturaEntity() {
        this.cursos = new ArrayList<CursoEntity>();
    }

    public void agregarCurso(CursoEntity curso) {
        cursos.add(curso);
    }
}
