package com.ceica.booklikes.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User extends ModeloBase {
    private int idusuario;
    private String nombre;
    private String password;

    public User() {
    }

    public User(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
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

   public List<User> getallUser(){
        List<User> userList= new ArrayList<>();
        User user=new User();
       Connection conn= user.getConnection();
       String sql="select  u.idusuario, u.nombre, u.password from booklikes.usuarios as u;";
       try {
           Statement st= conn.createStatement();
           ResultSet resultSet=st.executeQuery(sql);
           userList=readResulSet(resultSet);
       }catch (SQLException e){
           throw new RuntimeException(e);
       }
       return userList;
    }

    private List<User> readResulSet(ResultSet resultSet) throws SQLException {
        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.idusuario = resultSet.getInt("idusuario");
            user.nombre = resultSet.getString("nombre");
            user.password = resultSet.getString("password");
           userList.add(user);

        }
        return userList;
    }

    public User login(String nombre, String password){
        User user=new User();
        Connection conn=user.getConnection();
        String sql="select idusuario,nombre,password from  booklikes\n" +
                "where nombre=? and password=?";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,nombre);
            pst.setString(2,password);
            ResultSet resultSet=pst.executeQuery();
            if(resultSet.next()){
                user.idusuario =resultSet.getInt("idusuario");
                user.nombre =resultSet.getString("nombre");
                user.password= resultSet.getString("password");
                return user;
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }





    @Override
    protected String getNombreTabla() {
        return "usuarios";
    }
}
