import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            String nombreArchivo = "charangos.json";
            ArchivoCharango archivo = new ArchivoCharango(nombreArchivo);
            File f = new File(nombreArchivo);
            if (!f.exists()) {
                FileWriter fw = new FileWriter(f);
                fw.write("[]");
                fw.close();
                System.out.println("Archivo creado: " + nombreArchivo + "\n");
            } else {
                System.out.println("Archivo existente: " + nombreArchivo + "\n");
            }
            ArrayList<Boolean> cuerdas1 = new ArrayList<Boolean>(
                    Arrays.asList(true, false, false, true, true, false, false, false, true, true)
            );

            ArrayList<Boolean> cuerdas2 = new ArrayList<Boolean>(
                    Arrays.asList(true, true, true, true, true, true, true, true, true, true)
            );

            ArrayList<Boolean> cuerdas3 = new ArrayList<Boolean>(
                    Arrays.asList(false, false, false, false, false, false, false, false, false, false)
            );

            archivo.guardar(new Charango("Madera", cuerdas1));
            archivo.guardar(new Charango("Carbono", cuerdas2));
            archivo.guardar(new Charango("Madera", cuerdas3));

            System.out.println("Charangos guardados.\n");

            archivo.eliminarConMasDe6False();
            System.out.println("Eliminación de charangos con >6 cuerdas en false realizada.\n");

            System.out.println("Listar por material: Madera");
            archivo.listarPorMaterial("Madera");
            System.out.println();

            System.out.println("Charangos con 10 cuerdas:");
            archivo.buscarCon10Cuerdas();
            System.out.println();

            archivo.ordenarPorMaterial();
            System.out.println("Charangos ordenados por material y guardados.\n");
            Charango[] todos = archivo.cargarTodos();
            for (int i = 0; i < todos.length; i++) {
                System.out.println(todos[i]);
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
