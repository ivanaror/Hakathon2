package org.generation.models;

import org.generation.exceptions.AgendaLlena;
import org.generation.exceptions.ExistenciaUsuario;

import java.util.HashMap;
import java.util.Map;

// Agenda formada por un conjunto de contactos
public class Agenda {
    private final Map<String, Contacto> contactos;
    private static final int LIMITE = 10;

    public Agenda() {
        this.contactos = new HashMap<>();
    }

    // Funcionalidad para añadir un contacto -- incluye funcionalidades para revisar agenda llena y existencia de usuario.
    public void agregarContacto(Contacto contacto) throws AgendaLlena, ExistenciaUsuario {
        if (contactos.size() >= LIMITE) {
            throw new AgendaLlena("La agenda está llena.");
        }
        if (contactos.containsKey(contacto.getNombre().toLowerCase())) {
            throw new ExistenciaUsuario("El contacto ya existe.");
        }
        contactos.put(contacto.getNombre().toLowerCase(), contacto);
    }

    // Funcionalidad para eliminar a un contacto
    public boolean eliminarContacto(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return false;
        }
        return contactos.remove(nombre.toLowerCase()) != null;
    }

    // Funcionalidad para buscar un contacto con su nombre (FALTA MOSTRAR TELEFONO)
    public Contacto buscarContacto(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return null;
        }
        return contactos.get(nombre.toLowerCase());
    }

    // Funcionalidad para listar toda la agenda
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("--- Todos los Contactos ---");
            contactos.values().forEach(System.out::println);
        }
    }

    public int obtenerEspaciosDisponibles() {
        return LIMITE - contactos.size();
    }
}
