import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Archivoproducto {
    private String nomArch;
    private Gson gson = new Gson();
    
    public Archivoproducto(String nomArch) {
        this.nomArch = nomArch;
    }
    public void crearArchivo() throws IOException {
        ArrayList<Producto> lista = new ArrayList<>();
        guardar(lista);
    }
    private void guardar(ArrayList<Producto> lista) throws IOException {
        FileWriter writer = new FileWriter(nomArch);
        gson.toJson(lista, writer);
        writer.close();
    }
    private ArrayList<Producto> cargar() {
        try {
            FileReader reader = new FileReader(nomArch);
            Producto[] arreglo = gson.fromJson(reader, Producto[].class);
            reader.close();

            ArrayList<Producto> lista = new ArrayList<>();
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
    public void guardarProducto(Producto p) throws IOException {
        ArrayList<Producto> lista = cargar();
        lista.add(p);
        guardar(lista);
    }

    public Producto buscaProducto(int c) {
        ArrayList<Producto> lista = cargar();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo() == c) {
                return lista.get(i); 
            }
        }
        return null;
    }
    public float promedioPrecios() {
        ArrayList<Producto> lista = cargar();

        if (lista.size() == 0) return 0;

        float suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            suma += lista.get(i).getPrecio();
        }
        return suma / lista.size();
    }

    public Producto productoMasCaro() {
        ArrayList<Producto> lista = cargar();

        if (lista.size() == 0) return null;

        Producto mayor = lista.get(0);

        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).getPrecio() > mayor.getPrecio()) {
                mayor = lista.get(i);
            }
        }
        return mayor;
    }
}
