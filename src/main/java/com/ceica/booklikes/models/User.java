package com.ceica.booklikes.models;

public class User extends ModeloBase {
    private int idusuario;
    private String nombre;
    private String password;

    public User() {
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "idusuario=" + idusuario +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    protected String getNombreTabla() {
        return "usuarios";
    }
}
