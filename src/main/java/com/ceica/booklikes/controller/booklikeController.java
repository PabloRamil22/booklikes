package com.ceica.booklikes.controller;

import com.ceica.booklikes.dto.BookDto;
import com.ceica.booklikes.models.Book;
import com.ceica.booklikes.models.FavoriteBooks;
import com.ceica.booklikes.models.User;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class booklikeController {
    public User userLogged;

    public boolean login(String username,String password){

        User user=new User();
        userLogged=user.login(username,password);
        if(userLogged!=null){
            return true;
        }else {
            return false;
        }

    }

    public boolean createUser( String nombre, String password){
        User user=new User(nombre, password);
        return user.insertar("(nombre,password) values(?,?)",nombre,password);
    }
    public List<User>getallUser(){
        User user=new User();
        return user.getallUser();
    }

    public List<Book> getallBook(){
        Book book= new Book();
        return book.getAllBooks();
    }

    public List<BookDto> getallFavoriteBook(){
        Book book=new Book();
        return book.getallFavoriteBooks();
    }

    public boolean createBook(String autor, String titulo,String descripcion, User user){
        Book book = new Book();
        return book.insertar("(autor, titulo, descripcion, id_usuario) values(?,?,?,?)", autor,titulo,descripcion,user.getIdusuario());

    }

    public boolean deleteUser(int idUsuario){
        return new User().borrar("idusuario=?", idUsuario);
    }


    public boolean updatePasword(String nombre, String password){
        return new User().actualizar("password=? where nombre = ?", nombre,password );
    }

    public boolean deleteBook(int idLibro){
        return new Book().borrar("idlibro=?", idLibro);
    }

    public boolean updateDescriptionBook(String descripcion, String titulo){
        return new Book().actualizar("descripcion=? where titulo = ?", descripcion, titulo);
    }

    public int createFavoriteBook(int idLibro, int idUsuario){
        FavoriteBooks favoriteBooks=new FavoriteBooks();
        Connection conn=favoriteBooks.getConnection();
        String sql="select * from libros_favoritos where idlibro=? and idUsuario=?";
        PreparedStatement stm= null;
        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1,idLibro);
            stm.setInt(2,idUsuario);
            ResultSet rs=stm.executeQuery();
            if(rs.next()){
                int idfavorito=rs.getInt("id_favorito");

                favoriteBooks.borrar("id_favorito=?", idfavorito);
            }else{
                favoriteBooks.insertar("(idlibro, idusuario) values(?,?)", idLibro, idUsuario);
            }
            String sql2="select count(*) as favoritos from libros_favoritos where idlibro=?";
            stm= conn.prepareStatement(sql2);
            stm.setInt(1,idLibro);
            ResultSet rs1=stm.executeQuery();
            int fav=0;
            if(rs1.next()){
                fav=rs1.getInt("favoritos");
            }
            return fav;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean deleteFavoriteBook(int id_favorito){
        return new FavoriteBooks().borrar("id_favorito=?", id_favorito);
    }



}
