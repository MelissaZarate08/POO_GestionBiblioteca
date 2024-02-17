package models;

import java.util.ArrayList;

public class Bibliotecario {
    private String nombre;
    private String contraseña;

    public Bibliotecario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public void agregarLibro(ArrayList<Libro> inventario, String titulo, String autor, int año) {
        Libro libro = new Libro(titulo, autor, año);
        inventario.add(libro);
        System.out.println("Libro \"" + titulo + "\" ingresado al inventario.");
    }

    public void prestarLibro(ArrayList<Libro> inventario, ArrayList<Prestamo> prestamos, Usuario usuario, String tituloLibro) {
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

    public void devolverLibro(ArrayList<Libro> inventario, ArrayList<Prestamo> prestamos, String tituloLibro) {
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
    public void mostrarInventario(ArrayList<Libro> inventario){
        System.out.println("Inventario de la biblioteca");
        for (Libro libro : inventario) {
            System.out.println(libro);
        }
    }

}
