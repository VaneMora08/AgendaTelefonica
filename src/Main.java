import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        while (true) {
            System.out.println("\nMenú de la Agenda Telefónica:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Verificar si la agenda está llena");
            System.out.println("6. Ver espacio libre en la agenda");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto: ");
                    String telefono = scanner.nextLine();
                    Contacto nuevoContacto = new Contacto(nombre, telefono);
                    agenda.añadirContacto(nuevoContacto);
                    break;
                case 2:
                    agenda.listarContactos();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    nombre = scanner.nextLine();
                    Contacto buscarContacto = new Contacto(nombre, "");
                    if (agenda.existeContacto(buscarContacto)) {
                        System.out.println("El contacto existe en la agenda.");
                    } else {
                        System.out.println("El contacto no se encuentra en la agenda.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    nombre = scanner.nextLine();
                    Contacto eliminarContacto = new Contacto(nombre, "");
                    agenda.eliminarContacto(eliminarContacto);
                    break;
                case 5:
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena.");
                    } else {
                        System.out.println("La agenda no está llena.");
                    }
                    break;
                case 6:
                    System.out.println("Espacio libre en la agenda: " + agenda.espacioLibre());
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
