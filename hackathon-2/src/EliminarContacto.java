import java.util.ArrayList;
import java.util.HashMap;

public class EliminarContacto {
    public static boolean eliminarContacto(HashMap<String, Contacto> agenda, String nombre) {
        if (nombre == null || nombre.isEmpty()) return false;
        if (!agenda.containsKey(nombre)) return false;
        agenda.remove(nombre);
        return true;
    }
    void main(){
    }
}
