import domain.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ValidadorDeCorrelatividadesTest {
    private Materia sistemasYOrganizaciones;
    private Materia paradigmasDeProgramacion;
    private Materia matematicaDiscreta;
    private Materia algoritmosYEstructuraDeDatos;
    private Materia arquitecturaDeComputadoras;
    private Materia analisisDeSistemas;
    private Inscripcion inscripcion;
    private Inscripcion inscripcionFallida;
    private Alumno alumnoJuan;
    private Materia disenioDeSistemas;

    @BeforeEach
    void setup(){
        analisisDeSistemas = new Materia(NombreMateria.ANALISIS_DE_SISTEMAS);
        sistemasYOrganizaciones = new Materia(NombreMateria.SISTEMAS_Y_ORGANIZACIONES);
        algoritmosYEstructuraDeDatos = new Materia(NombreMateria.ALGORITMOS_Y_ESTRUCTURA_DE_DATOS);
        matematicaDiscreta = new Materia(NombreMateria.MATEMATICA_DISCRETA);
        paradigmasDeProgramacion = new Materia(NombreMateria.PARADIGMAS_DE_PROGRAMACION);
        disenioDeSistemas = new Materia(NombreMateria.DISENO_DE_SISTEMAS);

        paradigmasDeProgramacion.agregarCorrelativa(matematicaDiscreta);
        paradigmasDeProgramacion.agregarCorrelativa(algoritmosYEstructuraDeDatos);

        disenioDeSistemas.agregarCorrelativa(paradigmasDeProgramacion);
        disenioDeSistemas.agregarCorrelativa(algoritmosYEstructuraDeDatos);
        disenioDeSistemas.agregarCorrelativa(analisisDeSistemas);

        alumnoJuan = new Alumno("Juan", 1234);

    }

    @DisplayName("Una materia del primer año no tiene correlativas")
    @Test
    public void validarMateriasDelIngreso() {

        assertTrue(sistemasYOrganizaciones.getCorrelativas().isEmpty());
    }
    @DisplayName("Una materia de 2do año tiene correlativas")
    @Test
    public void validarMateriaDeSegundoAnio() {

        assertTrue(paradigmasDeProgramacion.getCorrelativas().contains(matematicaDiscreta));
        assertTrue(paradigmasDeProgramacion.getCorrelativas().contains(algoritmosYEstructuraDeDatos));
    }

    @DisplayName("Inscripción aprobada con correlativas controladas")
    @Test
    public void validarInscripcionCorrecta(){
        alumnoJuan.agregarMateriaAprobada(algoritmosYEstructuraDeDatos);
        alumnoJuan.agregarMateriaAprobada(matematicaDiscreta);
        List<Materia> listaDeMaterias = List.of(paradigmasDeProgramacion, sistemasYOrganizaciones);

        inscripcion = new Inscripcion(alumnoJuan, listaDeMaterias);

        assertTrue(inscripcion.aprobada());
    }

    @DisplayName("Inscripción no aprobada por falta de correlatividades")
    @Test
    public void validarInscripcionFallida(){
        alumnoJuan.agregarMateriaAprobada(algoritmosYEstructuraDeDatos);
        alumnoJuan.agregarMateriaAprobada(matematicaDiscreta);
        List<Materia> listaDeMaterias = List.of(paradigmasDeProgramacion, disenioDeSistemas);
        inscripcionFallida = new Inscripcion(alumnoJuan, listaDeMaterias);

        assertFalse(inscripcionFallida.aprobada());

    }


}