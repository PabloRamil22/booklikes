package com.ceica.booklikes.servlets;


public class LibrosDTO {
    private int id;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private String titulo;
    private String autor;

    private int favoritos;
    private String descripcion;

    public String getTitulo() {
        return titulo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(int favoritos) {
        this.favoritos = favoritos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}