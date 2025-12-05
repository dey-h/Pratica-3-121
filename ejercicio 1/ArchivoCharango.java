import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;

public class ArchivoCharango {

    private String nombreArchivo;
    private Gson gson = new Gson();

    public ArchivoCharango(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    public Charango[] cargarTodos() {
        try {
            FileReader fr = new FileReader(nombreArchivo);
            Charango[] arr = gson.fromJson(fr, Charango[].class);
            fr.close();

            if (arr == null) return new Charango[0];
            return arr;

        } catch (Exception e) {
            return new Charango[0];
        }
    }
    private void grabar(Charango[] arr) {
        try {
            FileWriter fw = new FileWriter(nombreArchivo);
            gson.toJson(arr, fw);
            fw.close();
        } catch (Exception e) {
            System.out.println("Error guardando");
        }
    }
    public void guardar(Charango c) {
        Charango[] viejo = cargarTodos();
        Charango[] nuevo = new Charango[viejo.length + 1];

        for (int i = 0; i < viejo.length; i++) {
            nuevo[i] = viejo[i];
        }
        nuevo[viejo.length] = c;

        grabar(nuevo);
    }
    public void eliminarConMasDe6False() {
        Charango[] arr = cargarTodos();
        int cont = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].cantCuerdasFalse() <= 6) {
                cont++;
            }
        }

        Charango[] nuevo = new Charango[cont];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].cantCuerdasFalse() <= 6) {
                nuevo[idx] = arr[i];
                idx++;
            }
        }

        grabar(nuevo);
    }
    public void listarPorMaterial(String x) {
        Charango[] arr = cargarTodos();
        System.out.println("Listando charangos que contienen: " + x);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getMaterial().toLowerCase().contains(x.toLowerCase())) {
                System.out.println(arr[i]);
            }
        }
    }

    public void buscarCon10Cuerdas() {
        Charango[] arr = cargarTodos();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getNroCuerdas() == 10) {
                System.out.println(arr[i]);
            }
        }
    }
    public void ordenarPorMaterial() {
        Charango[] arr = cargarTodos();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].getMaterial().compareToIgnoreCase(arr[j+1].getMaterial()) > 0) {
                    Charango aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = aux;
                }
            }
        }

        grabar(arr);
    }
}
