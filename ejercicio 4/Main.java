import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ArchivoNota arch = new ArchivoNota("notas.json");
            arch.crearArchivo();
            Nota n1 = new Nota("Matemáticas", 85);
            Nota n2 = new Nota("Programación", 95);

            n1.agregarEstudiante(new Estudiante(1846901, "Ana", "Lopez", "Gomez", 20));
            n1.agregarEstudiante(new Estudiante(4852902, "Luis", "Perez", "Rojas", 22));

            n2.agregarEstudiante(new Estudiante(1258803, "Maria", "Torrez", "Flores", 19));
            n2.agregarEstudiante(new Estudiante(782304, "Carlos", "Lima", "Vega", 21));
            n2.agregarEstudiante(new Estudiante(1638905, "Jose", "Vazquez", "Diaz", 23));

            arch.guardarNota(n1);
            arch.guardarNota(n2);

            System.out.println("Promedio general: " + arch.promedioNotas());

            System.out.println("Estudiantes con la mejor nota:");
            for (Estudiante e : arch.mejoresEstudiantes()) {
                System.out.println("RU: " + e.getRu() + " - " + e.getNombre());
            }
            arch.eliminarEstudiantes("Matemáticas");
            System.out.println("Estudiantes de Matemáticas eliminados.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
