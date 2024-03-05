package com.ceica.booklikes.models;

import java.util.Date;

public class FavoriteBooks extends ModeloBase{
    private int id_favorito;
    private  int idLibro;
    private int idUsuario;
    private Date fecha_favorito;

    public FavoriteBooks(int idLibro, int idUsuario) {
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
    }

    public FavoriteBooks() {
    }

    public int getId_favorito() {
        return id_favorito;
    }

    public void setId_favorito(int id_favorito) {
        this.id_favorito = id_favorito;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha_favorito() {
        return fecha_favorito;
    }

    public void setFecha_favorito(Date fecha_favorito) {
        this.fecha_favorito = fecha_favorito;
    }

    @Override
    public String toString() {
        return "FavoriteBooks{" +
                "id_favorito=" + id_favorito +
                ", idLibro=" + idLibro +
                ", idUsuario=" + idUsuario +
                ", fecha_favorito=" + fecha_favorito +
                '}';
    }

    @Override
    protected String getNombreTabla() {
        return "libros_favoritos";
    }
}
