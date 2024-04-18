package models;

import java.util.Scanner;

public class Bibliotecario {
    private String nombre;
    private String contraseña;
    private static Scanner scanner = new Scanner(System.in);
    private static Inventario inventario = new Inventario();

    public Bibliotecario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public void prestarLibro(Usuario usuario, String tituloLibro) {
        inventario.prestarLibro(usuario, tituloLibro);
    }

    public void devolverLibro(String tituloLibro) {
        inventario.devolverLibro(tituloLibro);
    }

    public void registrarPrestamo() {
        Usuario usuario = obtenerDatosUsuario();
        System.out.print("Ingrese el título del libro que desea prestar: ");
        String tituloPrestamo = scanner.nextLine();
        prestarLibro(usuario, tituloPrestamo);
    }


    public static Usuario obtenerDatosUsuario() {
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su dirección: ");
        String direccionUsuario = scanner.nextLine();
        return new Usuario(nombreUsuario, direccionUsuario);
    }
}