import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        ArchivoZoo arch = new ArchivoZoo("zoo.json");
        arch.crearArchivo();

        ArrayList<Zoologico> lista = new ArrayList<>();

        Zoologico z1 = new Zoologico(1, "Zoológico Central");
        z1.agregarAnimal(new Animal("panthera", "Leon", 2));
        z1.agregarAnimal(new Animal("ramphastos", "Tucan", 1));

        Zoologico z2 = new Zoologico(2, "Zoológico Norte");
        z2.agregarAnimal(new Animal("hapalochlaena", "Pulpo", 5));

        Zoologico z3 = new Zoologico(3, "Zoológico Vacío");

        lista.add(z1);
        lista.add(z2);
        lista.add(z3);

        arch.guardar(lista);

        System.out.println("Zoológicos con mayor variedad:");
        for (Zoologico z : arch.leer()) {
            if (z.getAnimales().size() >= 2) {
                System.out.println(z.getNombre());
            }
        }

        System.out.println("Zoológicos vacíos:");
        ArrayList<Zoologico> listAux = arch.leer();
        for (Zoologico z : listAux) {
            if (z.getAnimales().isEmpty()) {
                System.out.println(z.getNombre());
                arch.eliminar(z.getId());
            }
        }

        System.out.println("Animales de especie ''hapalochlaena:");
        for (Zoologico z : arch.leer()) {
            for (Animal a : z.getAnimales()) {
                if (a.getEspecie().equalsIgnoreCase("hapalochlaena")) {
                    System.out.println(z.getNombre() + ": " + a.getNombre());
                }
            }
        }

        int origen = 2;
        int destino = 1;

        ArrayList<Zoologico> zoos = arch.leer();
        Zoologico zooOrigen = null;
        Zoologico zooDestino = null;

        for (Zoologico z : zoos) {
            if (z.getId() == origen) zooOrigen = z;
            if (z.getId() == destino) zooDestino = z;
        }

        if (zooOrigen != null && zooDestino != null) {
            for (Animal a : zooOrigen.getAnimales()) {
                zooDestino.agregarAnimal(a);
            }
            zooOrigen.getAnimales().clear();
            zooOrigen.setAnimales(new ArrayList<>());
        }

        arch.guardar(zoos);

        System.out.println("Animales movidos del zoológico 2 al 1.");
    }
}
