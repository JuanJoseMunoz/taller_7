package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos;

import java.util.List;

import co.edu.unicauca.asae.taller7.taller_7.docente.dominio.modelos.Docente;

public class Curso {
    private Integer idCurso;
    private String nombre;
    private Integer matriculaEstimada;
    private List<FranjaHoraria> franjasHorarias;
    private Asignatura objAsignatura;
    private List<Docente> listaDocentes;

    public Curso() {}

    public Curso(String nombre, Integer matriculaEstimada) {
        this.nombre = nombre;
        this.matriculaEstimada = matriculaEstimada;
    }

    public Integer getIdCurso() { return idCurso; }
    public void setIdCurso(Integer idCurso) { this.idCurso = idCurso; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public Integer getMatriculaEstimada() { return matriculaEstimada; }
    public void setMatriculaEstimada(Integer matriculaEstimada) { this.matriculaEstimada = matriculaEstimada; }
    
    public List<FranjaHoraria> getFranjasHorarias() { return franjasHorarias; }
    public void setFranjasHorarias(List<FranjaHoraria> franjasHorarias) { this.franjasHorarias = franjasHorarias; }
    
    public Asignatura getObjAsignatura() { return objAsignatura; }
    public void setObjAsignatura(Asignatura objAsignatura) { this.objAsignatura = objAsignatura; }
    
    public List<Docente> getListaDocentes() { return listaDocentes; }
    public void setListaDocentes(List<Docente> listaDocentes) { this.listaDocentes = listaDocentes; }
}
