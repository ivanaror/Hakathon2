public class Main {
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

        System.out.print("Ingrese el nombre del contacto a buscar: ");
        String nombre = sc.nextLine();


        Contacto resultado = buscarContacto(agenda, nombre);

        if (resultado != null) {

            System.out.println("--- Usuario Encontrado ---");
            System.out.println("Nombre: " + resultado.getNombre());
            System.out.println("Teléfono: " + resultado.getNumero());
        } else {
            System.out.println("El usuario '" + nombre + "' no existe en la agenda.");
        }
        break;


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
