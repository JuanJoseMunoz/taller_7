package co.edu.unicauca.asae.taller7.taller_7.espacioFisico.infraestrutura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "espacios_fisicos")
public class EspacioFisicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false)
    private Integer capacidad;

    @Column(nullable = false, length = 8)
    private String estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objEspacioFisico")
    private List<FranjaHorariaEntity> franjasHorarias;

    public EspacioFisicoEntity() {
        this.franjasHorarias = new ArrayList<FranjaHorariaEntity>();
    }

    public void agregarFranjaHoraria(FranjaHorariaEntity objFranjaHoraria) {
        this.franjasHorarias.add(objFranjaHoraria);
    }
}
