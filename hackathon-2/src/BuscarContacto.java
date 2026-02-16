import java.util.HashMap;

public static Contacto buscarContacto(HashMap<String, Contacto> agenda, String nombre) {
    // busca la llave en el mapa y devuelve el objeto asociado
    return agenda.get(nombre);
}