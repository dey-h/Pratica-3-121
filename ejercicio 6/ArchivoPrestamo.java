import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ArchivoPrestamo {
    private String nomArch;
    private Gson gson = new Gson();

    public ArchivoPrestamo(String nomArch) {
        this.nomArch = nomArch;
    }

    public void crearArchivo() {
        try {
            ArrayList<Prestamo> lista = new ArrayList<>();
            guardar(lista);
        } catch (Exception e) {}
    }

    public void guardar(ArrayList<Prestamo> lista) {
        try {
            FileWriter writer = new FileWriter(nomArch);
            gson.toJson(lista, writer);
            writer.close();
        } catch (Exception e) {}
    }

    public ArrayList<Prestamo> cargar() {
        try {
            FileReader reader = new FileReader(nomArch);
            Prestamo[] arr = gson.fromJson(reader, Prestamo[].class);
            reader.close();

            ArrayList<Prestamo> lista = new ArrayList<>();
            if (arr != null) {
                for (Prestamo p : arr) {
                    lista.add(p);
                }
            }
            return lista;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void librosEntre(double x, double y, ArchivoLibro archLibro) {
        ArrayList<Libro> libros = archLibro.cargar();
        for (Libro l : libros) {
            if (l.getPrecio() >= x && l.getPrecio() <= y) {
                System.out.println(l.getCodLibro() + " - " + l.getTitulo() + " - " + l.getPrecio());
            }
        }
    }

    public double ingresoTotalLibro(int codLibro, ArchivoLibro archLibro) {
        ArrayList<Prestamo> pres = this.cargar();
        double cantidad = 0;
        for (Prestamo p : pres) {
            if (p.getCodLibro() == codLibro) cantidad += p.getCantidad();
        }

        double precio = 0;
        ArrayList<Libro> libros = archLibro.cargar();
        for (Libro l : libros) {
            if (l.getCodLibro() == codLibro) precio = l.getPrecio();
        }

        return cantidad * precio;
    }

    public void librosNuncaVendidos(ArchivoLibro archLibro) {
        ArrayList<Libro> libros = archLibro.cargar();
        ArrayList<Prestamo> pres = this.cargar();

        for (Libro l : libros) {
            boolean vendido = false;
            for (Prestamo p : pres) {
                if (p.getCodLibro() == l.getCodLibro()) vendido = true;
            }
            if (!vendido) System.out.println("no vendido: " + l.getTitulo());
        }
    }

    public void clientesDeLibro(int codLibro, ArchivoCliente archCliente) {
        ArrayList<Prestamo> pres = this.cargar();
        ArrayList<Cliente> clientes = archCliente.cargar();

        for (Prestamo p : pres) {
            if (p.getCodLibro() == codLibro) {
                for (Cliente c : clientes) {
                    if (c.getCodCliente() == p.getCodCliente()) {
                        System.out.println(c.getNombre() + " " + c.getApellido());
                    }
                }
            }
        }
    }

    public int libroMasPrestado() {
        ArrayList<Prestamo> pres = this.cargar();
        int mejor = -1;
        int maxCant = -1;

        for (Prestamo p1 : pres) {
            int total = 0;
            for (Prestamo p2 : pres) {
                if (p2.getCodLibro() == p1.getCodLibro()) total += p2.getCantidad();
            }
            if (total > maxCant) {
                maxCant = total;
                mejor = p1.getCodLibro();
            }
        }

        return mejor;
    }

    public int clienteMasPrestamos() {
        ArrayList<Prestamo> pres = this.cargar();
        int mejorCli = -1;
        int maxCant = -1;

        for (Prestamo p1 : pres) {
            int total = 0;
            for (Prestamo p2 : pres) {
                if (p2.getCodCliente() == p1.getCodCliente()) total += p2.getCantidad();
            }
            if (total > maxCant) {
                maxCant = total;
                mejorCli = p1.getCodCliente();
            }
        }

        return mejorCli;
    }
}
