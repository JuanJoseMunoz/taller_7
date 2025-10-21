package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cursos")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    @Column(unique = true, nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false)
    private Integer matriculaEstimada;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objCurso", cascade = CascadeType.REMOVE)
    private List<FranjaHorariaEntity> franjasHorarias;

    @ManyToOne()
    @JoinColumn(name = "asignatura_id", nullable = false)
    private AsignaturaEntity objAsignatura;

    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cursosdocente", joinColumns = @JoinColumn(name = "idCurso"), inverseJoinColumns = @JoinColumn(name = "idDocente"))
	private List<DocenteEntity> listaDocentes;

    public CursoEntity() {
        this.franjasHorarias = new ArrayList<FranjaHorariaEntity>();
        this.listaDocentes = new ArrayList<DocenteEntity>();
    }

    public void agregarFranjaHoraria(FranjaHorariaEntity objFranjaHoraria) {
        this.franjasHorarias.add(objFranjaHoraria);
    }

    public void agregarDocente(DocenteEntity objDocente) {
        this.listaDocentes.add(objDocente);
    }
}
