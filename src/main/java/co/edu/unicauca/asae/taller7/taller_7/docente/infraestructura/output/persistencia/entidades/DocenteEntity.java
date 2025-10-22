package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "persona_id")
@Getter
@Setter
@AllArgsConstructor
@Table(name = "docentes")
public class DocenteEntity extends PersonaEntity {
    @ManyToOne(cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
    @JoinColumn(name = "oficina_id", nullable = true)
    private OficinaEntity objOficina;

    @ManyToMany(mappedBy = "listaDocentes", fetch = FetchType.EAGER)
    private List<CursoEntity> listaCursos = new ArrayList<>();

    public DocenteEntity() {
    }

    public DocenteEntity(Integer idPersona, String nombre, String apellido, String correo) {
        super(idPersona, nombre, apellido, correo);
    }
}
