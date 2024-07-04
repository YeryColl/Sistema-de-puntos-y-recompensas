import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SistemaDePuntos sistema = new SistemaDePuntos();
        
        String archivoClientes = "clientes.txt";
        String archivoRecompensas = "recompensas.txt";

        sistema.cargarDatos(archivoClientes, archivoRecompensas);

        while (true) {
            System.out.println("1. Ingresar Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Registrar Compra");
            System.out.println("5. Agregar Recompensa");
            System.out.println("6. Canjear Recompensa");
            System.out.println("7. Mostrar Recompensas");
            System.out.println("8. Mostrar Recompensas Canjeables");
            System.out.println("9. Guardar y Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese nombre del cliente:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese ID del cliente:");
                    String id = scanner.nextLine();
                    sistema.agregarCliente(new Cliente(nombre, id));
                    break;
                case 2:
                    sistema.mostrarClientes();
                    break;
                case 3:
                    System.out.println("Ingrese ID del cliente a eliminar:");
                    id = scanner.nextLine();
                    sistema.eliminarCliente(id);
                    break;
                case 4:
                    System.out.println("Ingrese ID del cliente:");
                    id = scanner.nextLine();
                    System.out.println("Ingrese monto de la compra:");
                    double monto = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese descripción de la compra:");
                    String descripcionCompra = scanner.nextLine();
                    sistema.registrarCompra(id, monto, descripcionCompra);
                    break;
                case 5:
                    System.out.println("Ingrese descripción de la recompensa:");
                    String desc = scanner.nextLine();
                    System.out.println("Ingrese puntos necesarios:");
                    int puntos = scanner.nextInt();
                    scanner.nextLine();
                    sistema.agregarRecompensa(new Recompensa(desc, puntos));
                    break;
                case 6:
                    System.out.println("Ingrese ID del cliente:");
                    id = scanner.nextLine();
                    System.out.println("Ingrese descripción de la recompensa:");
                    String descripcionRecompensa = scanner.nextLine();
                    sistema.canjearRecompensa(id, descripcionRecompensa);
                    break;
                case 7:
                    sistema.mostrarRecompensas();
                    break;
                case 8:
                    System.out.println("Ingrese ID del cliente:");
                    id = scanner.nextLine();
                    sistema.mostrarRecompensasCanjeables(id);
                    break;
                case 9:
                    sistema.guardarDatos(archivoClientes, archivoRecompensas);
                    System.out.println("Datos guardados. Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
