package models;

public class Libro {
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private boolean prestado;

    public Libro(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.prestado = false;
    }
    public String getTitulo() {
        return titulo;
    }
    public boolean estaPrestado() {
        return prestado;
    }
    public void prestar() {
        prestado = true;
    }
    public void devolver() {
        prestado = false;
    }
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", añoPublicacion=" + añoPublicacion +
                ", prestado=" + prestado +
                '}';
    }

}

