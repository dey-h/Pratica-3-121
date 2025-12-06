import java.util.ArrayList;

public class Zoologico{
    private int id;
    private String nombre;
    private int nroAnimales;
    private ArrayList<Animal>animales;

    public Zoologico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.animales = new ArrayList<>();
        this.nroAnimales = 0;
    }
    public void agregarAnimal(Animal a) {
        animales.add(a);
        nroAnimales += a.getCantidad();
    }
    public int getId() { 
        return id; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public int getNroAnimales() { 
        return nroAnimales; 
    }
    public ArrayList<Animal> getAnimales() { 
        return animales; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    public void setAnimales(ArrayList<Animal> lista) {
        animales = lista;
        nroAnimales = 0;
        for (Animal a : lista) nroAnimales += a.getCantidad();
    }
}