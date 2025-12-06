import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArchivoFarmacia {
    private String nomArch;
    private Gson gson = new Gson();

    public ArchivoFarmacia(String nomArch) {
        this.nomArch = nomArch;
    }

    public void crearArchivo() throws IOException {
        ArrayList<Farmacia> lista = new ArrayList<>();
        guardar(lista);
    }

    private void guardar(ArrayList<Farmacia> lista) throws IOException {
        FileWriter writer = new FileWriter(nomArch);
        gson.toJson(lista, writer);
        writer.close();
    }

    private ArrayList<Farmacia> cargar() {
        try {
            FileReader reader = new FileReader(nomArch);
            Farmacia[] arreglo = gson.fromJson(reader, Farmacia[].class);
            reader.close();

            ArrayList<Farmacia> lista = new ArrayList<>();
            if (arreglo != null) {
                Collections.addAll(lista, arreglo);
            }
            return lista;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    public void agregarFarmacia(Farmacia f) throws IOException {
        ArrayList<Farmacia> lista = cargar();
        lista.add(f);
        guardar(lista);
    }
    public void mostrarTosSucursal(int suc) {
        ArrayList<Farmacia> lista = cargar();

        for (Farmacia f : lista) {
            if (f.getSucursal() == suc) {
                System.out.println("Sucursal " + suc + "  Medicamentos para la tos:");
                for (Medicamento med : f.getM()) {
                    if (med.getTipo().equalsIgnoreCase("tos")) {
                        System.out.println(med.getTipo() + " - Precio: " + med.getPrecio());
                    }
                }
            }
        }
    }
    public void buscarFarmaciaConTapsin() {
        ArrayList<Farmacia> lista = cargar();

        for (Farmacia f : lista) {
            for (Medicamento med : f.getM()) {
                if (med.getTipo().equalsIgnoreCase("Tapsin") ||
                    med.getTipo().equalsIgnoreCase("tapsin")) {

                    System.out.println(
                        "Sucursal: " + f.getSucursal() +
                        " - Dirección: " + f.getDireccion()
                    );
                }
            }
        }
    }
    public void buscarPorTipo(String tipo) {
        ArrayList<Farmacia> lista = cargar();

        System.out.println("Medicamentos tipo: " + tipo);
        for (Farmacia f : lista) {
            for (Medicamento med : f.getM()) {
                if (med.getTipo().equalsIgnoreCase(tipo)) {
                    System.out.println("Sucursal " + f.getSucursal() +
                            ": " + med.getTipo() + " - Precio: " + med.getPrecio());
                }
            }
        }
    }
    public void ordenarPorDireccion() throws IOException {
        ArrayList<Farmacia> lista = cargar();

        lista.sort(Comparator.comparing(Farmacia::getDireccion));

        guardar(lista);
        System.out.println("Farmacias ordenadas por dirección");
    }
    public void moverMedicamentos(String tipo, int sucursalOrigen, int sucursalDestino) throws IOException {
        ArrayList<Farmacia> lista = cargar();

        Farmacia origen = null;
        Farmacia destino = null;

        for (Farmacia f : lista) {
            if (f.getSucursal() == sucursalOrigen) origen = f;
            if (f.getSucursal() == sucursalDestino) destino = f;
        }

        if (origen == null || destino == null) {
            System.out.println("Error: Farmacia no encontrada.");
            return;
        }

        ArrayList<Medicamento> mover = new ArrayList<>();

        for (Medicamento med : origen.getM()) {
            if (med.getTipo().equalsIgnoreCase(tipo)) {
                mover.add(med);
            }
        }

        origen.getM().removeAll(mover);
        destino.getM().addAll(mover);

        guardar(lista);

        System.out.println("Se movieron " + mover.size() +
                           " medicamentos de tipo " + tipo +
                           " de la sucursal " + sucursalOrigen +
                           " a la " + sucursalDestino);
    }
}
