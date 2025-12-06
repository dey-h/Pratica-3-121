import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        ArchivoCobros archivo = new ArchivoCobros("cobros.json");

        archivo.crearArchivo();

        ArrayList<Transaccion> lista = archivo.cargar();

        lista.add(new Transaccion(1, 50.5, "01/01/2025"));
        lista.add(new Transaccion(2, 75.0, "02/01/2025"));
        lista.add(new Transaccion(3, 100.0, "03/01/2025"));

        archivo.guardar(lista);

        for (Transaccion t : archivo.cargar()) {
            System.out.println("id: " + t.getId() +
                               "  Monto: " + t.getMonto() +
                               "  Fecha: " + t.getFecha());
        }

        int buscarID = 2;
        System.out.println("buscar por id " + buscarID );

        boolean encontrado = false;
        for (Transaccion t : archivo.cargar()) {
            if (t.getId() == buscarID) {
                System.out.println("Transacción encontrada:");
                System.out.println(": " + t.getId() +
                                   "  Monto: " + t.getMonto() +
                                   "  Fecha: " + t.getFecha());
                encontrado = true;
                break;
            }
        }

        if (!encontrado)
            System.out.println("No existe una transacción con ese id.");
    }
}
