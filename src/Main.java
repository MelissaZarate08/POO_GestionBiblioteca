import models.Bibliotecario;
import models.Libro;
import models.Prestamo;
import models.Usuario;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Libro> inventario = new ArrayList<>();
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("---INGRESO DE LIBROS AL INVENTARIO---");
        while (true) {
            System.out.print("Ingrese el título del libro (o (fin) para terminar): ");
            String titulo = scanner.nextLine();
            if (titulo.equalsIgnoreCase("fin")) {
                break;
            }
            System.out.print("Ingrese el nombre del autor: ");
            String autor = scanner.nextLine();
            System.out.print("Ingrese el año de publicación: ");
            int año = scanner.nextInt();
            scanner.nextLine();
            inventario.add(new Libro(titulo, autor, año));
        }

        int rol;
        do {
            System.out.println("\n---SELECCIONAR ROL DENTRO DE LA BIBLIOTECA---");
            System.out.println("1. Usuario");
            System.out.println("2. Bibliotecario");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            rol = scanner.nextInt();
            scanner.nextLine();

            switch (rol) {
                case 1:
                    System.out.print("Ingrese su nombre de usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese su Direccion: ");
                    String direccionUsuario = scanner.nextLine();

                    Usuario usuario = new Usuario(nombreUsuario, direccionUsuario);

                    System.out.println("Bienvenido!!, " + nombreUsuario);
                    for (Libro libro : inventario) {
                        System.out.println(libro);
                    }
                    System.out.print("\nIngrese el título del libro que desea prestar: ");
                    String tituloPrestamo = scanner.nextLine();
                    for (Libro libro : inventario) {
                        if (libro.getTitulo().equals(tituloPrestamo)) {
                            libro.prestar();
                            prestamos.add(new Prestamo(usuario, libro));
                            System.out.println("El libro \"" + tituloPrestamo + "\" ha sido prestado a " + usuario.getNombre());
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.print("Ingrese su nombre de bibliotecario: ");
                    String nombreBibliotecario = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    String contraseñaBibliotecario = scanner.nextLine();

                    Bibliotecario bibliotecario = new Bibliotecario(nombreBibliotecario, contraseñaBibliotecario);

                    System.out.println("¡Bienvenido, " + nombreBibliotecario + "!\n");

                    int opcion;
                    do {
                        System.out.println("Menú de opciones:");
                        System.out.println("1. Agregar libro al inventario");
                        System.out.println("2. Prestar libro");
                        System.out.println("3. Devolver libro");
                        System.out.println("4. Ver inventario");
                        System.out.println("5. Cambiar de rol o salir");
                        System.out.print("Ingrese su opción: ");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1:
                                System.out.println("Ingreso de libros al inventario:");
                                System.out.print("Ingrese el título del libro: ");
                                String tituloLibro = scanner.nextLine();
                                System.out.print("Ingrese el nombre del autor: ");
                                String autor = scanner.nextLine();
                                System.out.print("Ingrese el año de publicación: ");
                                int año = scanner.nextInt();
                                scanner.nextLine();
                                bibliotecario.agregarLibro(inventario, tituloLibro, autor, año);
                                break;
                            case 2:
                                System.out.print("Ingrese su nombre de usuario: ");
                                String nombreUsuarioPrestamo = scanner.nextLine();
                                Usuario usuarioPrestamo = new Usuario(nombreUsuarioPrestamo, "");
                                System.out.print("Ingrese el título del libro que desea prestar: ");
                                tituloPrestamo = scanner.nextLine();
                                bibliotecario.prestarLibro(inventario, prestamos, usuarioPrestamo, tituloPrestamo);
                                break;

                            case 3:
                                System.out.print("Ingrese el título del libro que desea devolver: ");
                                String tituloDevolucion = scanner.nextLine();
                                bibliotecario.devolverLibro(inventario, prestamos, tituloDevolucion);
                                break;
                            case 4:
                                bibliotecario.mostrarInventario(inventario);
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opción inválida.");
                        }
                    } while (opcion != 5);
                    break;

                case 3:
                    System.out.println("saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 3.");
            }
        } while (rol != 3);

        scanner.close();
    }
}