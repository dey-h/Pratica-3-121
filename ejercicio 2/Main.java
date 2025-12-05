public class Main {
    public static void main(String[] args) {

        try {
            ArchivoTrabajador archivo = new ArchivoTrabajador("trabajadores.json");

            archivo.crearArchivo();
            archivo.guardarTrabajador(new Trabajador("Ana", 125101, 1200));
            archivo.guardarTrabajador(new Trabajador("Luis", 138702, 1500));
            archivo.guardarTrabajador(new Trabajador("Maria", 115803, 1100));
            archivo.guardarTrabajador(new Trabajador("Pedro", 1258404, 1300));
            archivo.aumentarSalario(102, 250);
            System.out.println("Salario aumentado para carnet 102.");

            Trabajador mayor = archivo.mayorSalario();
            if (mayor != null) {
                System.out.println("Trabajador con mayor salario:");
                System.out.println(mayor.getNombre() + " - " + mayor.getSalario() + "");
            }
            System.out.println("Trabajadores ordenados por salario:");
            for (Trabajador t : archivo.ordenarPorSalario()) {
                System.out.println(t.getNombre() + " - " + t.getSalario());
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
