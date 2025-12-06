public class Operador {
    private int idOperador;
    private String nombre;

    public Operador(int idOperador, String nombre) {
        this.idOperador = idOperador;
        this.nombre = nombre;
    }

    public int getIdOperador() { return idOperador; }
    public String getNombre() { return nombre; }
}
