package domain;
import java.util.ArrayList;
import java.util.List;
public class Alumno {
    private String nombre;
    private int legajo;
    private List<Materia> materiasAprobadas;
    public Alumno(String nombre, int legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    public void agregarMateriaAprobada(Materia materia){
        materiasAprobadas.add(materia);
    }

    public List<Materia> materiasAprobadas(){
        return materiasAprobadas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLegajo() {
        return legajo;
    }

}
