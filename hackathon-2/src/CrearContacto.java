import java.util.Map;

public class CrearContacto {

    public static void crear(Map<String, Contacto> agenda, Contacto nuevo, int LIMITE) {
        // Verificar que el limite sea menor a 10
        if (agenda.size() >= LIMITE) {
            System.out.println("No se puede agregar: Se encuentra llena la agenda");
            return;
        }

        // Verificar si ya existe
        String clave = nuevo.getNombre().toLowerCase();
        if (agenda.containsKey(clave)) {
            System.out.println("No se puede agregar: Este contacto ya existe");
            return;
        }

        // Agregar contacto
        agenda.put(clave, nuevo);
        System.out.println("Contacto agregado correctamente");
        System.out.println("Espacios disponibles en la agenda: " + (LIMITE - agenda.size()));
    }
}

