package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    private static ArrayList<Libro> inventario = new ArrayList<>();
    private static ArrayList<Prestamo> prestamos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void agregarLibro(String titulo, String autor, int año) {
        inventario.add(new Libro(titulo, autor, año));
        System.out.println("Libro \"" + titulo + "\" ingresado al inventario.");
    }

    public void prestarLibro(Usuario usuario, String tituloLibro) {
        for (Libro libro : inventario) {
            if (libro.getTitulo().equals(tituloLibro) && !libro.estaPrestado()) {
                libro.prestar();
                prestamos.add(new Prestamo(usuario, libro));
                System.out.println("El libro \"" + tituloLibro + "\" ha sido prestado a " + usuario.getNombre());
                return;
            }
        }
        System.out.println("El libro \"" + tituloLibro + "\" no está disponible para préstamo.");
    }

    public void devolverLibro(String tituloLibro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getTitulo().equals(tituloLibro)) {
                prestamo.getLibro().devolver();
                prestamos.remove(prestamo);
                System.out.println("El libro \"" + tituloLibro + "\" ha sido devuelto.");
                return;
            }
        }
        System.out.println("El libro \"" + tituloLibro + "\" no fue prestado.");
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("No hay libros en el inventario :(");
        } else {
            System.out.println("Inventario de la biblioteca");
            for (Libro libro : inventario) {
                System.out.println(libro);
            }
        }
    }

    public void agregarLibroInventario() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el nombre del autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el año de publicación: ");
        int año = scanner.nextInt();
        scanner.nextLine();
        agregarLibro(titulo, autor, año);
    }
}
