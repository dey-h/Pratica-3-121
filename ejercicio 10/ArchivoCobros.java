import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoCobros {
    private String nomArch;
    private Gson gson = new Gson();

    public ArchivoCobros(String nomArch) {
        this.nomArch = nomArch;
    }

    public void crearArchivo() throws IOException {
        FileWriter fw = new FileWriter(nomArch);
        fw.write("[]");
        fw.close();
    }

    public ArrayList<Transaccion> cargar() {
        try {
            FileReader fr = new FileReader(nomArch);
            return gson.fromJson(fr, new TypeToken<ArrayList<Transaccion>>(){}.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void guardar(ArrayList<Transaccion> lista) throws IOException {
        FileWriter fw = new FileWriter(nomArch);
        gson.toJson(lista, fw);
        fw.close();
    }
}

