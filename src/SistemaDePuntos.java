import java.io.*;
import java.util.ArrayList;

public class SistemaDePuntos {
    private ArrayList<Cliente> clientes;
    private ArrayList<Recompensa> recompensas;

    public SistemaDePuntos() {
        this.clientes = new ArrayList<>();
        this.recompensas = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarRecompensa(Recompensa recompensa) {
        recompensas.add(recompensa);
    }

    public Cliente buscarCliente(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public void registrarCompra(String idCliente, double monto, String descripcion) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null) {
            int puntos = (int) monto;
            cliente.acumularPuntos(puntos);
            System.out.println("Compra registrada: " + descripcion + " - Monto: " + monto + " - Puntos acumulados: " + puntos*0.01);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void canjearRecompensa(String idCliente, String descripcionRecompensa) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null) {
            for (Recompensa recompensa : recompensas) {
                if (recompensa.getDescripcion().equals(descripcionRecompensa) &&
                        cliente.getPuntos() >= recompensa.getPuntosNecesarios()) {
                    cliente.redimirPuntos(recompensa.getPuntosNecesarios());
                    System.out.println("Recompensa canjeada: " + descripcionRecompensa + " - Puntos usados: " + recompensa.getPuntosNecesarios());
                    return;
                }
            }
            System.out.println("No se puede canjear la recompensa: Puntos insuficientes o recompensa no encontrada.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void guardarDatos(String archivoClientes, String archivoRecompensas) {
        try (BufferedWriter writerClientes = new BufferedWriter(new FileWriter(archivoClientes));
             BufferedWriter writerRecompensas = new BufferedWriter(new FileWriter(archivoRecompensas))) {
            for (Cliente cliente : clientes) {
                writerClientes.write(cliente.getNombre() + "," + cliente.getId() + "," + cliente.getPuntos());
                writerClientes.newLine();
            }
            for (Recompensa recompensa : recompensas) {
                writerRecompensas.write(recompensa.getDescripcion() + "," + recompensa.getPuntosNecesarios());
                writerRecompensas.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDatos(String archivoClientes, String archivoRecompensas) {
        try (BufferedReader readerClientes = new BufferedReader(new FileReader(archivoClientes));
             BufferedReader readerRecompensas = new BufferedReader(new FileReader(archivoRecompensas))) {
            String linea;
            while ((linea = readerClientes.readLine()) != null) {
                String[] datos = linea.split(",");
                Cliente cliente = new Cliente(datos[0], datos[1]);
                cliente.acumularPuntos(Integer.parseInt(datos[2]));
                clientes.add(cliente);
            }
            while ((linea = readerRecompensas.readLine()) != null) {
                String[] datos = linea.split(",");
                Recompensa recompensa = new Recompensa(datos[0], Integer.parseInt(datos[1]));
                recompensas.add(recompensa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void mostrarRecompensas() {
        for (Recompensa recompensa : recompensas) {
            System.out.println(recompensa);
        }
    }

    public void mostrarRecompensasCanjeables(String idCliente) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null) {
            System.out.println("Recompensas canjeables para el cliente " + cliente.getNombre() + ":");
            for (Recompensa recompensa : recompensas) {
                if (cliente.getPuntos() >= recompensa.getPuntosNecesarios()) {
                    System.out.println(recompensa);
                }
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void eliminarCliente(String id) {
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }
}
