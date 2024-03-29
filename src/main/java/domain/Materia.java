package domain;
import java.util.ArrayList;
import java.util.List;


public class Materia {
    private NombreMateria nombre;
    private List<Materia> correlativas;

    public Materia(NombreMateria nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativa(Materia materia) {
        correlativas.add(materia);
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

}
