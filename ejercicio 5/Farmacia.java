import java.util.ArrayList;

public class Farmacia {
    private String nomFarmacia;
    private int sucursal;
    private String direccion;
    private int nroMedicamentos;
    private ArrayList <Medicamento> m;

    public Farmacia(String nomFarmacia,int sucursal,String direccion ){
        this.nomFarmacia=nomFarmacia;
        this.sucursal=sucursal;
        this.direccion=direccion;
        this.nroMedicamentos=0;
        this.m = new ArrayList<>();
    }
    public int getSucursal(){
        return sucursal;
    }
    public String getDireccion(){
        return direccion;
    }
    public ArrayList<Medicamento> getM() {
         return m; 
    }
    public void agregarMedicamento(Medicamento med){
        m.add(med);
    }
    public void mostrarMedicamentos(){
        for (Medicamento med : m) {
            System.out.println(med.getTipo() + " - " + med.getPrecio());
        }
    }
    public ArrayList<Medicamento> ObtenerPorTipo(String tipo){
        ArrayList<Medicamento> lista = new ArrayList<>();
        for (Medicamento med : m) {
            if (med.getTipo().equalsIgnoreCase(tipo)) {
                lista.add(med);
            }
        }
        return lista;
    }
}
