import java.util.ArrayList;

public class Charango {
    private String material;
    private int nroCuerdas;
    private ArrayList<Boolean> cuerdas;

    public Charango(String material, ArrayList<Boolean> cuerdas) {
        this.material = material;
        this.cuerdas = cuerdas;
        this.nroCuerdas = cuerdas.size();
    }
    public String getMaterial() {
        return material;
    }
    public int getNroCuerdas() {
        return nroCuerdas;
    }
    public ArrayList<Boolean> getCuerdas() {
        return cuerdas;
    }
    public int cantCuerdasFalse() {
        int c = 0;
        for (boolean b : cuerdas)
            if (!b) c++;
        return c;
    }
    public String toString() {
        return "Material: " + material + " | Cuerdas: " + nroCuerdas;
    }
}
