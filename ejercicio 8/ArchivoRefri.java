import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoRefri {

    private String nomArch;
    private Gson gson = new Gson();

    public ArchivoRefri(String nomArch) {
        this.nomArch = nomArch;
    }

    public void crearArchivo() throws IOException {
        ArrayList<Alimento> lista = new ArrayList<>();
        guardar(lista);
    }

    public void guardar(ArrayList<Alimento> lista) throws IOException {
        FileWriter writer = new FileWriter(nomArch);
        gson.toJson(lista, writer);
        writer.close();
    }

    public ArrayList<Alimento> cargar() {
        try {
            FileReader reader = new FileReader(nomArch);
            Alimento[] arreglo = gson.fromJson(reader, Alimento[].class);
            reader.close();

            ArrayList<Alimento> lista = new ArrayList<>();
            if (arreglo != null)
                for (int i = 0; i < arreglo.length; i++)
                    lista.add(arreglo[i]);

            return lista;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void modificarPorNombre(String nombre, String nuevaFecha, int nuevaCantidad) throws IOException {
        ArrayList<Alimento> lista = cargar();

        for (Alimento a : lista) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                a.setFechaVencimiento(nuevaFecha);
                a.setCantidad(nuevaCantidad);
            }
        }
        guardar(lista);
    }

    public void eliminarPorNombre(String nombre) throws IOException {
        ArrayList<Alimento> lista = cargar();
        ArrayList<Alimento> nuevaLista = new ArrayList<>();

        for (Alimento a : lista) {
            if (!a.getNombre().equalsIgnoreCase(nombre)) {
                nuevaLista.add(a);
            }
        }

        guardar(nuevaLista);
    }

    public void mostrarCaducadosAntesDe(String fechaX) {
        ArrayList<Alimento> lista = cargar();
        System.out.println("alimentos que vencen antes de " + fechaX);

        for (Alimento a : lista) {
            if (a.getFechaVencimiento().compareTo(fechaX) < 0) {
                System.out.println(a.getNombre() + "  vence: " + a.getFechaVencimiento());
            }
        }
    }
    public void eliminarCantidadCero() throws IOException {
        ArrayList<Alimento> lista = cargar();
        ArrayList<Alimento> nuevaLista = new ArrayList<>();

        for (Alimento a : lista) {
            if (a.getCantidad() > 0) {
                nuevaLista.add(a);
            }
        }
        guardar(nuevaLista);
    }

    public void mostrarVencidos(String fechaHoy) {
        ArrayList<Alimento> lista = cargar();
        System.out.println("alimentos vencidos:");

        for (Alimento a : lista) {
            if (a.getFechaVencimiento().compareTo(fechaHoy) < 0) {
                System.out.println(a.getNombre() + " vencido en  " + a.getFechaVencimiento());
            }
        }
    }

    public void alimentoMayorCantidad() {
        ArrayList<Alimento> lista = cargar();

        if (lista.size() == 0) {
            System.out.println("No hay alimentos registrados.");
            return;
        }

        int max = 0;
        for (int i = 0; i < lista.size(); i++)
            if (lista.get(i).getCantidad() > max)
                max = lista.get(i).getCantidad();

        System.out.println("alimentos con mayor cantidad(" + max + "):");
        for (Alimento a : lista)
            if (a.getCantidad() == max)
                System.out.println(a.getNombre());
    }
}
