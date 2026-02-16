import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static void main(String[] args) {

        // Crear agenda //
        // Crear agenda //

        // Agregar Contacto //
        // Agregar Contacto //

        // Existe Contacto //
        // Existe Contacto //

        // Listar Contactos //
        // Listar Contactos //

        // Buscar Contacto //
        // Buscar Contacto //
        
                HashMap<String, Contacto> agenda = new HashMap<>();
                
                System.out.print("Nombre a buscar: ");
                String nombreBusqueda = sc.nextLine();

             
                Contacto encontrado = buscarContacto(agenda, nombreBusqueda);

                if (encontrado != null) {
                    System.out.println("Encontrado -> Nombre: " + encontrado.getNombre() +
                            " | Tel: " + encontrado.getNumero());
                } else {
                    System.out.println("No existe en la agenda.");
                }
            }
            
            public static Contacto buscarContacto(HashMap<String, Contacto> agenda, String nombre) {
                // .get() ahora funcionará porque importamos HashMap y definimos los tipos
                return agenda.get(nombre);
            }
        }

        // Eliminar Contacto //
        // Eliminar Contacto //

        // Agenda llena //
        // Agenda llena //

        // Espacios libres //
        // Espacios libres //

        // funcion Main //
        // funcion Main //


    }
}
