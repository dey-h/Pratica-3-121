import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        ArchivoNiño arch = new ArchivoNiño("niños.json");

        arch.crearArchivo(); 
        ArrayList<Niño> niños = arch.cargar();
        niños.add(new Niño("Juan", "Perez", "Lopez", 1111, 5, 18, 110));
        niños.add(new Niño("Maria", "Torrez", "Gomez", 2222, 4, 14, 95));
        niños.add(new Niño("Luis", "Gomez", "Rios", 3333, 6, 30, 150));

        arch.guardar(niños);

        System.out.println("lista de niños:");
        for (Niño n : niños)
            System.out.println(n.getNombre() + " - " + n.getEdad() + " años");

        System.out.println("niños con peso adecuado");
        for (Niño n : niños)
            if (n.getPeso() >= n.getEdad() * 3 && n.getPeso() <= n.getEdad() * 5)
                System.out.println(n.getNombre());

        System.out.println("niños con talla incorrecta");
        for (Niño n : niños)
            if (!(n.getPeso() >= n.getEdad() * 3 && n.getPeso() <= n.getEdad() * 5))
                System.out.println(n.getNombre());

        double suma = 0;
        for (Niño n : niños)
            suma += n.getEdad();
        double promedio = suma / niños.size();
        System.out.println("Promedio edad: " + promedio);

        int buscarCi = 2222;
        System.out.println("buscar pr ci X " + buscarCi + ":");
        for (Niño n : niños)
            if (n.getCi() == buscarCi)
                System.out.println("Encontrado: " + n.getNombre());

        double maxTalla = 0;
        for (Niño n : niños)
            if (n.getTalla() > maxTalla)
                maxTalla = n.getTalla();

        System.out.println("niños con talla mas alta:");
        for (Niño n : niños)
            if (n.getTalla() == maxTalla)
                System.out.println(n.getNombre() + " - " + n.getTalla() + " cm");
    }
}

