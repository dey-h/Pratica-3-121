import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ArchivoFarmacia arch = new ArchivoFarmacia("farmacias.json");

            arch.crearArchivo();
            Farmacia f1 = new Farmacia("Farmacorp", 1, "Av. España");
            Farmacia f2 = new Farmacia("Farmacias Bolivia", 2, "Calle Bolívar");
            Farmacia f3 = new Farmacia("Farmacia Chavez", 3, "Av. Aroma");

            
            f1.agregarMedicamento(new Medicamento("Jarabe Tos", 10, "tos", 20));
            f1.agregarMedicamento(new Medicamento("Tapsin", 12, "Tapsin", 15));
            f1.agregarMedicamento(new Medicamento("Ibuprofeno", 11, "antiinflamatorio", 10));

            f2.agregarMedicamento(new Medicamento("Pastillas Tos", 20, "tos", 18));
            f2.agregarMedicamento(new Medicamento("Tapsin Forte", 21, "Tapsin", 25));

     
            f3.agregarMedicamento(new Medicamento("Paracetamol", 30, "analgésico", 5));
        
            arch.agregarFarmacia(f1);
            arch.agregarFarmacia(f2);
            arch.agregarFarmacia(f3);

          
            System.out.println(" Medicamentos para tos, Sucursal 1:");
            arch.mostrarTosSucursal(1);

            System.out.println("Farmacias con Tapsin:");
            arch.buscarFarmaciaConTapsin();

            System.out.println("Medicamentos tipo 'tos':");
            arch.buscarPorTipo("tos");

            System.out.println(" Ordenando farmacias por dirección...");
            arch.ordenarPorDireccion();
            System.out.println(" Moviendo medicamentos 'tos' de sucursal 1 a sucursal 3...");
            arch.moverMedicamentos("tos", 1, 3);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
