import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArchivoLibro archLibro = new ArchivoLibro("libros.json");
        ArchivoCliente archCliente = new ArchivoCliente("clientes.json");
        ArchivoPrestamo archPrestamo = new ArchivoPrestamo("prestamos.json");

        archLibro.crearArchivo();
        archCliente.crearArchivo();
        archPrestamo.crearArchivo();

        ArrayList<Libro> libros = archLibro.cargar();
        libros.add(new Libro(11451, "Java Básico", 50));
        libros.add(new Libro(21447, "Algoritmos", 70));
        libros.add(new Libro(31514, "Estructuras de Datos", 60));
        libros.add(new Libro(45114, "python", 60));
        archLibro.guardar(libros);

        ArrayList<Cliente> clientes = archCliente.cargar();
        clientes.add(new Cliente(14185, 123456, "Juan", "Pérez"));
        clientes.add(new Cliente(29647, 789101, "Ana", "López"));
        clientes.add(new Cliente(48851, 189213, "Luis", "Gómez"));
        archCliente.guardar(clientes);

        ArrayList<Prestamo> prestamos = archPrestamo.cargar();
        prestamos.add(new Prestamo(14185, 11451, "01/12/2025", 2));
        prestamos.add(new Prestamo(29647, 21447, "02/12/2025", 1));
        prestamos.add(new Prestamo(29647, 21447, "03/12/2025", 3));
        prestamos.add(new Prestamo(48851, 31514, "04/12/2025", 1));
        archPrestamo.guardar(prestamos);

        System.out.println("Libros con precio entre 50 y 70:");
        archPrestamo.librosEntre(50, 70, archLibro);

        System.out.println("Ingreso total del libro 2: " +
                archPrestamo.ingresoTotalLibro(21447, archLibro));

        System.out.println("Libros nunca vendidos:");
        archPrestamo.librosNuncaVendidos(archLibro);

        System.out.println("Clientes que compraron el libro 2:");
        archPrestamo.clientesDeLibro(21447, archCliente);

        System.out.println("Libro más prestado codigo: " +
                archPrestamo.libroMasPrestado());

        System.out.println("Cliente con más préstamos codigo : " +
                archPrestamo.clienteMasPrestamos());
    }
}
    
