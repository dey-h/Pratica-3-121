import java.util.ArrayList;

public class Nota {
    private String materia;
    private int notaFinal;
    private ArrayList<Estudiante>estudiantes;

    public Nota(String materia, int notaFinal){
        this.materia=materia;
        this.notaFinal=notaFinal;
        this.estudiantes = new ArrayList<>();
    }
    public String getMateria() {
         return materia; 
    }
    public int getNotaFinal() {
         return notaFinal; 
    }
    public ArrayList<Estudiante> getEstudiantes() {
         return estudiantes; 
    }
    public void setEstudiantes(ArrayList<Estudiante> lista) {
        this.estudiantes = lista;
    }
    public void agregarEstudiante(Estudiante e){
        estudiantes.add(e);
    }
}
