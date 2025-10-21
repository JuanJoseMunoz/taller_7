package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller7.taller_7.espacioFisico.dominio.modelos.EspacioFisico;

public class FranjaHoraria {
    private Integer id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private EspacioFisico objEspacioFisico;
    private Curso objCurso;

    public FranjaHoraria() {}

    public FranjaHoraria(String dia, LocalTime horaInicio, LocalTime horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getDia() { return dia; }
    public void setDia(String dia) { this.dia = dia; }
    
    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }
    
    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }
    
    public EspacioFisico getObjEspacioFisico() { return objEspacioFisico; }
    public void setObjEspacioFisico(EspacioFisico objEspacioFisico) { this.objEspacioFisico = objEspacioFisico; }
    
    public Curso getObjCurso() { return objCurso; }
    public void setObjCurso(Curso objCurso) { this.objCurso = objCurso; }
}
