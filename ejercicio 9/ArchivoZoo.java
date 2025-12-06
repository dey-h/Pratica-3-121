import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoZoo {
    private String nomArch;
    private Gson gson = new Gson();

    public ArchivoZoo(String nomArch) {
        this.nomArch = nomArch;
    }

    public void crearArchivo() throws IOException {
        FileWriter fw = new FileWriter(nomArch);
        fw.write("[]");
        fw.close();
    }
    public ArrayList<Zoologico> leer() {
        try {
            FileReader fr = new FileReader(nomArch);
            return gson.fromJson(fr, new TypeToken<ArrayList<Zoologico>>(){}.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void guardar(ArrayList<Zoologico> lista) throws IOException {
        FileWriter fw = new FileWriter(nomArch);
        gson.toJson(lista, fw);
        fw.close();
    }

    public void modificar(int id, String nuevoNombre) throws IOException {
        ArrayList<Zoologico> lista = leer();
        for (Zoologico z : lista) {
            if (z.getId() == id) {
                z.setNombre(nuevoNombre);
                break;
            }
        }
        guardar(lista);
    }
    public void eliminar(int id) throws IOException {
        ArrayList<Zoologico> lista = leer();
        lista.removeIf(z -> z.getId() == id);
        guardar(lista);
    }
}
