import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoCliente {
    private String nomArch;
    private Gson gson = new Gson();

    public ArchivoCliente(String nomArch) {
        this.nomArch = nomArch;
    }

    public void crearArchivo() throws IOException {
        ArrayList<Cliente> lista = new ArrayList<>();
        guardar(lista);
    }

    public void guardar(ArrayList<Cliente> lista) throws IOException {
        FileWriter writer = new FileWriter(nomArch);
        gson.toJson(lista, writer);
        writer.close();
    }

    public ArrayList<Cliente> cargar() {
        try {
            FileReader reader = new FileReader(nomArch);
            Cliente[] arreglo = gson.fromJson(reader, Cliente[].class);
            reader.close();

            ArrayList<Cliente> lista = new ArrayList<>();
            if (arreglo != null) {
                for (Cliente c : arreglo) {
                    lista.add(c);
                }
            }
            return lista;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
