public class Transaccion {
    private int id;
    private double monto;
    private String fecha;

    public Transaccion(int id, double monto, String fecha) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
    }
    public int getId() { return id; }
    public double getMonto() { return monto; }
    public String getFecha() { return fecha; }
}
