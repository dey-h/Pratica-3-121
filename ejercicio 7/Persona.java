public class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int ci;

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, int ci) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.ci = ci;
    }
    public int getCi() {
         return ci; 
    }
    public String getNombre() {
         return nombre; 
    }
    public String getApellidoPaterno() {
         return apellidoPaterno; 
    }
    public String getApellidoMaterno() {
         return apellidoMaterno; 
    }
    
}