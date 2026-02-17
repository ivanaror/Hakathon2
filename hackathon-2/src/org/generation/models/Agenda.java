package org.generation.models;

import org.generation.exceptions.AgendaLlena;
import org.generation.exceptions.ExistenciaUsuario;

import java.util.HashMap;
import java.util.Map;

public class Agenda {
    private final Map<String, Contacto> contactos;
    private final int limite;

    public Agenda() {
        this(10);
    }

    public Agenda(int limite) {
        this.contactos = new HashMap<>();
        this.limite = limite;
    }

    public void agregarContacto(Contacto contacto) throws AgendaLlena, ExistenciaUsuario {
        if (contactos.size() >= limite) {
            throw new AgendaLlena("La agenda está llena."); // Funcionalidad agenda llena
        }
        if (contactos.containsKey(contacto.getNombre().toLowerCase())) {
            throw new ExistenciaUsuario("El contacto ya existe.");  // Funcionalidad existencia de usuario
        }
        contactos.put(contacto.getNombre().toLowerCase(), contacto);
    }

    public boolean eliminarContacto(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return false;
        }
        return contactos.remove(nombre.toLowerCase()) != null;
    }

    public Contacto buscarContacto(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return null;
        }
        return contactos.get(nombre.toLowerCase());
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("--- Todos los Contactos ---");
            contactos.values().forEach(System.out::println);
        }
    }

    public int obtenerEspaciosDisponibles() {
        return limite - contactos.size();
    }
}
