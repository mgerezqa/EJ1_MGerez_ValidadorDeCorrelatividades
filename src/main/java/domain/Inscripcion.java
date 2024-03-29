package domain;

import java.util.List;

public class Inscripcion {  // Inscripcion
    private final Alumno alumno;  // Alumno
    private final List <Materia> materias;  // Materia

    public Inscripcion(Alumno alumno, List <Materia> materiasAInscribirse) {  // Inscripcion
        this.alumno = alumno;  // Alumno
        this.materias = materiasAInscribirse;  // Materia
    }

    public Alumno getAlumno() {  // Alumno
        return alumno;  // Alumno
    }

    public List<Materia> getMaterias() {  // Materias
        return materias;  // Materias
    }

    //TODO
    public boolean aprobada() {
        for (Materia materia : materias) {
            if (!alumno.cumpleConCorrelativa(materia)) {
                return false;
            }
        }
        return true;
    }


}
