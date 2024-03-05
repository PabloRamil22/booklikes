package com.ceica.booklikes.dto;

import com.ceica.booklikes.models.ModeloBase;

import java.util.Date;

public class BookDto {


    private int idLibro;
    private String autor;
    private String titulo;
    private int favoritos;

    public BookDto(int idLibro, String autor, String titulo, int favoritos) {
        this.idLibro = idLibro;
        this.autor = autor;
        this.titulo = titulo;
        this.favoritos = favoritos;
    }

    public BookDto() {
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
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


}
