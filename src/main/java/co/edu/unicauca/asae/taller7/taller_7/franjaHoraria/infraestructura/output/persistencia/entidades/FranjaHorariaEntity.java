package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.output.persistencia.entidades;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos.Curso;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "franjas_horarias")
public class FranjaHorariaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String dia;

    @Column(nullable = false)
    private LocalTime hora_inicio;

    @Column(nullable = false)
    private LocalTime hora_fin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "espacio_fisico_id", nullable = false)
    private EspacioFisico objEspacioFisico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso objCurso;
}
