package com.ceica.booklikes.models;

import java.util.Date;

public class Book extends ModeloBase{

    private int idLibro;
    private String autor;
    private String titulo;
    private Date fecha_creacion;

    private String descripcion;

    private User id_usuario;

    public Book() {
    }

    public Book(String autor, String titulo) {
        this.autor = autor;
        this.titulo = titulo;
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

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public User getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(User id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idLibro=" + idLibro +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                ", descripcion='" + descripcion + '\'' +
                ", id_usuario=" + id_usuario +
                '}';
    }

    @Override
    protected String getNombreTabla() {
        return "libros";
    }
}
