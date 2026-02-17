import org.generation.models.Contacto;
import org.generation.models.Agenda;
import org.generation.exceptions.AgendaLlena;
import org.generation.exceptions.ExistenciaUsuario;
import org.generation.exceptions.InvalidData;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Define el tamaño de la agenda: ");
        int limiteAgenda = 10;
        if (scanner.hasNextInt()) {
            limiteAgenda = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Entrada no válida, usando tamaño por defecto: 10.");
            scanner.nextLine();
        }

        Agenda agenda = new Agenda(limiteAgenda);
        boolean salir = false;

        while (!salir) {
            imprimirMenu();
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> agregarNuevoContacto(scanner, agenda);
                    case 2 -> agenda.listarContactos();
                    case 3 -> {
                        try {
                            buscarContacto(scanner, agenda);
                        } catch (ExistenciaUsuario e) {
                            System.err.println("Error en la búsqueda: " + e.getMessage());
                        }
                    }
                    case 4 -> eliminarContacto(scanner, agenda);
                    case 5 -> System.out.println("Espacios disponibles: " + agenda.obtenerEspaciosDisponibles());
                    case 6 -> verificarExistencia(scanner, agenda);
                    case 7 -> salir = true;
                    default -> System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } else {
                System.err.println("Error de entrada: '" + scanner.nextLine() + "' no es un número válido.");
            }
        }
        System.out.println("¡Adiós!");
    }

    private static void imprimirMenu() {
        System.out.println("\n--- Menú de Agenda ---");
        System.out.println("1. Agregar nuevo contacto");
        System.out.println("2. Listar todos los contactos");
        System.out.println("3. Buscar un contacto");
        System.out.println("4. Eliminar un contacto");
        System.out.println("5. Ver espacios disponibles");
        System.out.println("6. Verificar si un contacto existe");
        System.out.println("7. Salir");
        System.out.print("Elige una opción: ");
    }

    private static int leerEntero(Scanner scanner) throws InvalidData {
        String entrada = scanner.nextLine();
        if (entrada.matches("\\d+")) {
            return Integer.parseInt(entrada);
        } else {
            throw new InvalidData("'" + entrada + "' no es un número válido.");
        }
    }

    private static long leerLargo(Scanner scanner) throws InvalidData {
        String entrada = scanner.nextLine();
        if (entrada.matches("\\d+")) {
            return Long.parseLong(entrada);
        } else {
            throw new InvalidData("'" + entrada + "' no es un número válido.");
        }
    }

    private static void agregarNuevoContacto(Scanner scanner, Agenda agenda) {
        try {
            System.out.print("Ingresa el nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingresa el número de teléfono: ");
            long numero = leerLargo(scanner);

            agenda.agregarContacto(new Contacto(nombre, numero));
            System.out.println("Contacto agregado exitosamente.");
        } catch (InvalidData | AgendaLlena | ExistenciaUsuario e) {
            System.err.println("Error al agregar contacto: " + e.getMessage());
        }
    }


    private static void buscarContacto(Scanner scanner, Agenda agenda) throws ExistenciaUsuario {
        System.out.print("Ingresa el nombre a buscar: ");
        String nombreBusqueda = scanner.nextLine();
        Contacto encontrado = agenda.buscarContacto(nombreBusqueda);
        if (encontrado != null) {
            System.out.println("\n Información del Contacto ");
            System.out.println("Nombre: " + encontrado.getNombre());
            System.out.println("Teléfono: " + encontrado.getNumero());
        } else {
            throw new ExistenciaUsuario("Contacto no encontrado.");
        }
    }

    private static void verificarExistencia(Scanner scanner, Agenda agenda) {
        System.out.print("Ingresa el nombre a verificar: ");
        String nombreVerificar = scanner.nextLine();
        if (agenda.buscarContacto(nombreVerificar) != null) {
            System.out.println("El contacto '" + nombreVerificar + "' existe en la agenda.");
        } else {
            System.out.println("El contacto '" + nombreVerificar + "' no existe en la agenda.");
        }
    }

    private static void eliminarContacto(Scanner scanner, Agenda agenda) {
        System.out.print("Ingresa el nombre a eliminar: ");
        String nombreEliminar = scanner.nextLine();
        if (agenda.eliminarContacto(nombreEliminar)) {
            System.out.println("Contacto eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar. Contacto no encontrado.");
        }
    }
}
