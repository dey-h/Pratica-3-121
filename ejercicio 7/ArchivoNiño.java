import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoNiño {
    private String nomArch;
    private Gson gson = new Gson();

    public ArchivoNiño(String nomArch) {
        this.nomArch = nomArch;
    }

    public void crearArchivo() throws IOException {
        ArrayList<Niño> lista = new ArrayList<>();
        guardar(lista);
    }

    public void guardar(ArrayList<Niño> lista) throws IOException {
        FileWriter writer = new FileWriter(nomArch);
        gson.toJson(lista, writer);
        writer.close();
    }

    public ArrayList<Niño> cargar() {
        try {
            FileReader reader = new FileReader(nomArch);
            Niño[] arreglo = gson.fromJson(reader, Niño[].class);
            reader.close();

            ArrayList<Niño> lista = new ArrayList<>();
            if (arreglo != null)
                for (int i = 0; i < arreglo.length; i++)
                    lista.add(arreglo[i]);

            return lista;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
