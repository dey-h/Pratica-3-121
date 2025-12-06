import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        ArchivoRefri arch = new ArchivoRefri("refri.json");
        arch.crearArchivo();

        ArrayList<Alimento> lista = arch.cargar();

        lista.add(new Alimento("Leche", "2025-01-10", 2));
        lista.add(new Alimento("Yogurt", "2024-12-01", 0));
        lista.add(new Alimento("Manzanas", "2025-02-15", 10));
        lista.add(new Alimento("Queso", "2024-11-30", 5));

        arch.guardar(lista);

        arch.modificarPorNombre("Leche", "2025-03-01", 4);

        arch.mostrarCaducadosAntesDe("2025-01-01");

        arch.eliminarCantidadCero();

        arch.mostrarVencidos("2024-12-10");

        arch.alimentoMayorCantidad();
    }
}
