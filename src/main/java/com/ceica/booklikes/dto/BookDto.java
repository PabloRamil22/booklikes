package com.ceica.booklikes.dto;

import com.ceica.booklikes.models.ModeloBase;

import java.util.Date;

public class BookDto {


    private int idlibro;
    private String autor;
    private String titulo;
    private int favoritos;

    private String nombre;

    public BookDto(int idlibro, String autor, String titulo, int favoritos, String nombre) {
        this.idlibro = idlibro;
        this.autor = autor;
        this.titulo = titulo;
        this.favoritos = favoritos;
        this.nombre = nombre;
    }

    public BookDto() {
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idLibro) {
        this.idlibro = idLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public int getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(int favoritos) {
        this.favoritos = favoritos;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "idlibro=" + idlibro +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", favoritos=" + favoritos +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
