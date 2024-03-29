package domain;

public class Inscripcion {  // Inscripcion
    private final Alumno alumno;  // Alumno
    private final Materia materia;  // Materia

    public Inscripcion(Alumno alumno, Materia materia) {  // Inscripcion
        this.alumno = alumno;  // Alumno
        this.materia = materia;  // Materia
    }

    public Alumno getAlumno() {  // Alumno
        return alumno;  // Alumno
    }

    public Materia getMateria() {  // Materia
        return materia;  // Materia
    }

    public boolean aprobada() {
//        return alumno.materiasAprobadas().containsAll(materia.getCorrelativas());
            return materia.getCorrelativas().containsAll(alumno.materiasAprobadas());
    }

}
