import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private int maxSize;

    public Agenda() {
        this(10); // Tamaño por defecto 10
    }

    public Agenda(int maxSize) {
        this.maxSize = maxSize;
        this.contactos = new ArrayList<>();
    }

    public void añadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("No se pueden añadir más contactos, la agenda está llena.");
            return;
        }
        if (existeContacto(c)) {
            System.out.println("El contacto ya existe en la agenda.");
            return;
        }
        contactos.add(c);
        System.out.println("Contacto añadido: " + c);
    }

    public boolean existeContacto(Contacto c) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(c.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
    }

    public void eliminarContacto(Contacto c) {
        Contacto contactoAEliminar = null;
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(c.getNombre())) {
                contactoAEliminar = contacto;
                break;
            }
        }
        if (contactoAEliminar != null) {
            contactos.remove(contactoAEliminar);
            System.out.println("Contacto eliminado: " + contactoAEliminar);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public boolean agendaLlena() {
        return contactos.size() >= maxSize;
    }

    public int espacioLibre() {
        return maxSize - contactos.size();
    }
}
