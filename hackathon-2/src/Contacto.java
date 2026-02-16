import java.util.HashMap;
import java.util.Map;

class Contacto {

    private String nombre;
    private int numero;

    private static Map<String, Contacto> agenda = new HashMap<>();
    private static final int LIMITE = 10;

    public Contacto(String nombre, int numero) {
        this.setNombre(nombre);
        this.setNumero(numero);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static void CrearContacto(Contacto nuevo) {
        if (agenda.size() >= LIMITE) {
            System.out.println("No se puede agregar: Se encuentra llena la agenda");
            return;
        }

        if (agenda.containsKey(nuevo.getNombre().toLowerCase())) {
            System.out.println("No se puede agregar: Este contacto ya existe");
            return;
        }


        agenda.put(nuevo.getNombre().toLowerCase(), nuevo);
        System.out.println("Contacto agregado correctamente");
        System.out.println("Espacios disponibles en la agenda: " + (LIMITE - agenda.size()));
    }
}

