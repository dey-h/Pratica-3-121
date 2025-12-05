public class Main {
    public static void main(String[] args) {

        try {
            Archivoproducto archivo = new Archivoproducto("productos.json");

            archivo.crearArchivo();

            archivo.guardarProducto(new Producto(1, "Leche", 5.50f));
            archivo.guardarProducto(new Producto(2, "Pan", 3.00f));
            archivo.guardarProducto(new Producto(3, "Queso", 12.75f));
            archivo.guardarProducto(new Producto(4, "Huevos", 8.20f));


            Producto buscado = archivo.buscaProducto(3);

            if (buscado != null) {
                System.out.println("Producto encontrado:");
                System.out.println("Código: " + buscado.getCodigo());
                System.out.println("Nombre: " + buscado.getNombre());
                System.out.println("Precio: " + buscado.getPrecio());
            } else {
                System.out.println("Producto no encontrado.");
            }
        
            float promedio = archivo.promedioPrecios();
            System.out.println("Promedio de precios: " + promedio);

            Producto caro = archivo.productoMasCaro();

            if (caro != null) {
                System.out.println("Producto más caro:");
                System.out.println("Código: " + caro.getCodigo());
                System.out.println("Nombre: " + caro.getNombre());
                System.out.println("Precio: " + caro.getPrecio());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
