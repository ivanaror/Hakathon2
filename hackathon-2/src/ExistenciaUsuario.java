import java.util.HashMap;

public class ExistenciaUsuario {

    public static boolean existe(HashMap<String, Contacto> indice, String nombre, String telefono) {

        String keyNombre = "N:" + nombre.toLowerCase().trim();
        String keyTelefono = "T:" + telefono.trim();

        if (indice.containsKey(keyNombre) || indice.containsKey(keyTelefono)) {
            System.out.println("Este contacto ya existe");
            return true;
        }

        System.out.println("Este contacto no existe");
        return false;
    }
}

