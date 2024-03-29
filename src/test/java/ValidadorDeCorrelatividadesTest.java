import domain.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorDeCorrelatividadesTest {
    private Materia analisismatematicoI;
    private Materia algebra;
    private Materia paradigmasDeProgramacion;
    private Materia matematicaDiscreta;
    private Materia algoritmosYEstructuraDeDatos;
    private Materia arquitecturaDeComputadoras;

    private Alumno unAlumno;

    @BeforeEach
    void setup(){
        analisismatematicoI = new Materia(NombreMateria.ANALISIS_MATEMATICO);
        algebra = new Materia(NombreMateria.ALGEBRA);
        paradigmasDeProgramacion = new Materia(NombreMateria.PARADIGMAS_DE_PROGRAMACION);
        algoritmosYEstructuraDeDatos = new Materia(NombreMateria.ALGORITMOS_Y_ESTRUCTURA_DE_DATOS);
        matematicaDiscreta = new Materia(NombreMateria.MATEMATICA_DISCRETA);
        unAlumno = new Alumno("Juan", 1234);



    }

    @DisplayName("Una materia del primer año no tiene correlativas")
    @Test
    public void validarMateriasDelIngreso() {

        assertTrue(analisismatematicoI.getCorrelativas().isEmpty());
        assertTrue(algebra.getCorrelativas().isEmpty());

    }


    @DisplayName("Una materia troncal de 2do año tiene correlativas")
    @Test
    public void validarMateriaDeSegundoAnio() {

        paradigmasDeProgramacion.agregarCorrelativa(matematicaDiscreta);
        paradigmasDeProgramacion.agregarCorrelativa(algoritmosYEstructuraDeDatos);

        assertTrue(paradigmasDeProgramacion.getCorrelativas().contains(matematicaDiscreta));
        assertTrue(paradigmasDeProgramacion.getCorrelativas().contains(algoritmosYEstructuraDeDatos));
    }

    @DisplayName("Un alumno que aprobo dos materias troncales de 1er año puede inscribirse a una correlativa de 2do")
    @Test
    public void validarMateriasAprobadas(){
        unAlumno.agregarMateriaAprobada(algoritmosYEstructuraDeDatos);
        unAlumno.agregarMateriaAprobada(matematicaDiscreta);
        assertEquals(2, unAlumno.materiasAprobadas().size());
        assertTrue(unAlumno.materiasAprobadas().contains(algoritmosYEstructuraDeDatos));
        assertTrue(unAlumno.materiasAprobadas().contains(matematicaDiscreta));
    }

}