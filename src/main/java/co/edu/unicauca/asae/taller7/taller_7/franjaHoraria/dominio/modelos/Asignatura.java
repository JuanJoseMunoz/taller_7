package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.modelos;

public class Asignatura {
    private Integer id;
    private String nombre;
    private Integer creditos;

    public Asignatura() {}

    public Asignatura(String nombre, Integer creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public Integer getCreditos() { return creditos; }
    public void setCreditos(Integer creditos) { this.creditos = creditos; }
}
