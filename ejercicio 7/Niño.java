public class Niño extends Persona{
    private int edad;
    private double peso;
    private double talla;

    public Niño(String nombre, String apellidoPaterno, String apellidoMaterno, int ci, int edad, double peso, double talla) {
        super(nombre, apellidoPaterno, apellidoMaterno, ci);
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }
    public int getEdad() {
         return edad; 
    }
    public double getPeso() {
         return peso; 
    }
    public double getTalla() {
         return talla; 
    }
}
