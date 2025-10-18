package co.edu.unicauca.asae.taller7.taller_7.docente.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "oficinas")
@Getter
@Setter
public class OficinaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false, length = 20)
    private String nombre;
    @Column(nullable = false, length = 20)
    private String ubicacion;

    @OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER, mappedBy = "objOficina")
    private List<DocenteEntity> docentes;

    public OficinaEntity() {
        this.docentes = new ArrayList<DocenteEntity>();
    }

    public void agregarDocente(DocenteEntity objDocente) {
        this.docentes.add(objDocente);
    }
}
