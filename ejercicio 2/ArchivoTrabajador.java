import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoTrabajador {

    String nomArch;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ArchivoTrabajador(String nombreArch) {
        this.nomArch = nombreArch;
    }
    public void crearArchivo() throws IOException {
        ArrayList<Trabajador> lista = new ArrayList<>();
        guardarLista(lista);
    }
    private void guardarLista(ArrayList<Trabajador> lista) throws IOException {
        FileWriter writer = new FileWriter(nomArch);
        gson.toJson(lista, writer);
        writer.close();
    }
    private ArrayList<Trabajador> cargarLista() {
        try {
            FileReader reader = new FileReader(nomArch);
            Trabajador[] arreglo = gson.fromJson(reader, Trabajador[].class);
            reader.close();

            ArrayList<Trabajador> lista = new ArrayList<>();
            if (arreglo != null) {
                for (int i = 0; i < arreglo.length; i++) {
                    lista.add(arreglo[i]);
                }
            }
            return lista;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    public void guardarTrabajador(Trabajador t) throws IOException {
        ArrayList<Trabajador> lista = cargarLista();
        lista.add(t);
        guardarLista(lista);
    }
    public void aumentarSalario(int carnet, double aumento) throws IOException {
        ArrayList<Trabajador> lista = cargarLista();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCarnet() == carnet) {
                double nuevo = lista.get(i).getSalario() + aumento; 
                lista.get(i).setSalario(nuevo); 
            }
        }
        guardarLista(lista);
    }
    public Trabajador mayorSalario() {
        ArrayList<Trabajador> lista = cargarLista();
        if (lista.size() == 0) return null;

        Trabajador mayor = lista.get(0);
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).getSalario() > mayor.getSalario()) {
                mayor = lista.get(i);
            }
        }
        return mayor;
    }
    public ArrayList<Trabajador> ordenarPorSalario() {
        ArrayList<Trabajador> lista = cargarLista();

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - 1 - i; j++) {
                if (lista.get(j).getSalario() > lista.get(j + 1).getSalario()) {
                    Trabajador tmp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, tmp);
                }
            }
        }
        return lista;
    }
}
