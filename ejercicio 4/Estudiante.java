public class Estudiante{
    private int ru;
    private String nombre;
    private String paterno;
    private String materno;
    private int edad;

    public Estudiante(int ru, String nombre, String paterno, String materno, int edad){
        this.ru=ru;
        this.nombre=nombre;
        this.paterno=paterno;
        this.materno=materno;
        this.edad=edad;
    }
    public int getRu() {
         return ru; 
    }
    public String getNombre() {
         return nombre; 
    }
    public String getPaterno() {
         return paterno; 
    }
    public String getMaterno() {
         return materno; 
    }
    public int getEdad() {
         return edad; 
    }

}
