public class Alimento {
    private String nombre;
    private String fechaVencimiento;
    private int cantidad;

    public Alimento(String nombre, String fechaVencimiento, int cantidad) {
        this.nombre = nombre;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
    }
    public String getNombre() {
         return nombre; 
    }
    public String getFechaVencimiento() {
         return fechaVencimiento; 
    }
    public int getCantidad() {
         return cantidad; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    public void setFechaVencimiento(String fechaVencimiento) { 
        this.fechaVencimiento = fechaVencimiento; 
    }
    public void setCantidad(int cantidad) { 
        this.cantidad = cantidad; 
    }
}
