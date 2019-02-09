package com.iteso.sesion5;

public class Alumno {

    String nombre;
    String telefono;
    String escolaridad;
    String genero;
    String libro_favorito;
    String deporte;

    public Alumno() {
        this.nombre = "";
        this.telefono = "";
        this.escolaridad = "";
        this.genero = "";
        this.libro_favorito = "";
        this.deporte = "";
    }

    public Alumno(String nombre, String telefono, String escolaridad, String genero, String libro_favorito, String deporte) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.escolaridad = escolaridad;
        this.genero = genero;
        this.libro_favorito = libro_favorito;
        this.deporte = deporte;
    }

    public String toString() {
        return "Nombre: "+nombre+"\n"+
               "Telefono: "+telefono+"\n"+
                "Escolaridad: "+escolaridad+"\n"+
                "Género: "+escolaridad+"\n"+
                "Libro Favorito: "+libro_favorito+"\n"+
                "Practica Deporte: "+deporte;
    }

}
