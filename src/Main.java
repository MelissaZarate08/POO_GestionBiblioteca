import models.Bibliotecario;
import models.Inventario;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Bibliotecario bibliotecario = new Bibliotecario("Bibliotecario", "1234");
    public static Inventario inventario = new Inventario();

    public static void main(String[] args) {
        int rol;
        do {
            rol = seleccionarRol();

            switch (rol) {
                case 1:
                    System.out.println("\n---MENÚ USUARIO---");
                    System.out.println("1. Ver libros que dispone la biblioteca");
                    System.out.println("2. Volver al menú principal");
                    System.out.print("Ingrese su opción: ");
                    int opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            inventario.mostrarInventario();
                            break;

                        case 2:
                            break;

                        default:
                            System.out.println("Opción inválida");
                    }

                    break;

                case 2:
                    bibliotecarioMenu();
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida (ingrese un número del 1 al 3)");
            }
        } while (rol != 3);

        scanner.close();
    }

    private static int seleccionarRol() {
        System.out.println("\n-----SELECCIONE SU ROL EN LA BIBLIOTECA-----");
        System.out.println("1. Usuario");
        System.out.println("2. Bibliotecario");
        System.out.println("3. Salir");
        System.out.print("Ingrese su opción: ");
        return scanner.nextInt();
    }

    private static void bibliotecarioMenu() {
        int opcion;
        do {
            System.out.println("\n-----MENÚ BIBLIOTECARIO-----");
            System.out.println("1. Agregar Libro al Inventario");
            System.out.println("2. Registrar Préstamo");
            System.out.println("3. Registrar Devolución");
            System.out.println("4. Ver Inventario");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    inventario.agregarLibroInventario();
                    break;

                case 2:
                    bibliotecario.registrarPrestamo();
                    break;

                case 3:
                    System.out.print("Ingrese el título del libro que desea devolver: ");
                    String tituloDevolucion = scanner.nextLine();
                    bibliotecario.devolverLibro(tituloDevolucion);
                    break;
                case 4:
                    inventario.mostrarInventario();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }
}