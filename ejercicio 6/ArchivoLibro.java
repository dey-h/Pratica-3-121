import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoLibro {
    private String nomArch;
    private Gson gson = new Gson();

    public ArchivoLibro(String nomArch) {
        this.nomArch = nomArch;
    }

    public void crearArchivo() throws IOException {
        ArrayList<Libro> lista = new ArrayList<>();
        guardar(lista);
    }

    public void guardar(ArrayList<Libro> lista) throws IOException {
        FileWriter writer = new FileWriter(nomArch);
        gson.toJson(lista, writer);
        writer.close();
    }

    public ArrayList<Libro> cargar() {
        try {
            FileReader reader = new FileReader(nomArch);
            Libro[] arreglo = gson.fromJson(reader, Libro[].class);
            reader.close();

            ArrayList<Libro> lista = new ArrayList<>();
            if (arreglo != null) {
                for (Libro l : arreglo) {
                    lista.add(l);
                }
            }
            return lista;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}

