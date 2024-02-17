package models;

public class Usuario {
    private String nombre;
    private String direccion;


    public Usuario(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }
}
