import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ArchivoNota {
    private String nomArch;
    private Gson gson = new Gson();
    
    public ArchivoNota(String nomArch) {
        this.nomArch = nomArch;
    }
    public void crearArchivo() throws IOException {
        ArrayList<Nota> lista = new ArrayList<>();
        guardar(lista);
    }
    private void guardar(ArrayList<Nota> lista) throws IOException {
        FileWriter writer = new FileWriter(nomArch);
        gson.toJson(lista, writer);
        writer.close();
    }
    private ArrayList<Nota> cargar() {
        try {
            FileReader reader = new FileReader(nomArch);
            Nota[] arreglo = gson.fromJson(reader, Nota[].class);
            reader.close();

            ArrayList<Nota> lista = new ArrayList<>();
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
    public void guardarNota(Nota n) throws IOException {
        ArrayList<Nota> lista = cargar();
        lista.add(n);
        guardar(lista);
    }
    public void agregarEstudiantes(String materia, ArrayList<Estudiante> nuevos) throws IOException {
        ArrayList<Nota> notas = cargar();

        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i).getMateria().equals(materia)) {

                ArrayList<Estudiante> lista = notas.get(i).getEstudiantes();

                for (int j = 0; j < nuevos.size(); j++) {
                    lista.add(nuevos.get(j));
                }

                notas.get(i).setEstudiantes(lista);
            }
        }

        guardar(notas);
    }
    public float promedioNotas() {
        ArrayList<Nota> notas = cargar();

        if (notas.size() == 0) return 0;

        float suma = 0;
        for (int i = 0; i < notas.size(); i++) {
            suma += notas.get(i).getNotaFinal();
        }

        return suma / notas.size();
    }
    public ArrayList<Estudiante> mejoresEstudiantes() {
        ArrayList<Nota> notas = cargar();
        ArrayList<Estudiante> mejores = new ArrayList<>();

        if (notas.size() == 0) return mejores;

        int max = notas.get(0).getNotaFinal();
        for (int i = 1; i < notas.size(); i++) {
            if (notas.get(i).getNotaFinal() > max) {
                max = notas.get(i).getNotaFinal();
            }
        }

        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i).getNotaFinal() == max) {

                ArrayList<Estudiante> ests = notas.get(i).getEstudiantes();

                for (int j = 0; j < ests.size(); j++) {
                    mejores.add(ests.get(j));
                }
            }
        }

        return mejores;
    }
    public void eliminarEstudiantes(String materia) throws IOException {
        ArrayList<Nota> notas = cargar();

        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i).getMateria().equals(materia)) {
                notas.get(i).setEstudiantes(new ArrayList<>()); 
            }
        }

        guardar(notas);
    }
}
