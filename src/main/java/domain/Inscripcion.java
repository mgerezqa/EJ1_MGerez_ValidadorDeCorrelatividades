package domain;

import java.util.List;

public class Inscripcion {  // Inscripcion
    private final Alumno alumno;  // Alumno
    private final List <Materia> materias;  // Materia

    public Inscripcion(Alumno alumno, List <Materia> materiasAInscribirse) {
        this.alumno = alumno;  // Alumno
        this.materias = materiasAInscribirse;  // Materia
    }
    public Alumno getAlumno() {  // Alumno
        return alumno;  // Alumno
    }

    public List<Materia> getMaterias() {  // Materias
        return materias;  // Materias
    }

    public boolean aprobada() {
        return materias.stream().allMatch(materia -> alumno.cumpleConCorrelativa(materia));

    }


}
