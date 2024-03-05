package com.ceica.booklikes.controller;

import com.ceica.booklikes.dto.BookDto;
import com.ceica.booklikes.models.Book;
import com.ceica.booklikes.models.FavoriteBooks;
import com.ceica.booklikes.models.User;

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

    public boolean createBook(String autor, String titulo,String descripcion){
        Book book = new Book();
        return book.insertar("(autor, titulo, descripcion, id_usuario) values(?,?,?,?)", autor,titulo,descripcion,userLogged.getIdusuario());

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

    public boolean createFavoriteBook(int idLibro, int idUsuario){
        FavoriteBooks favoriteBooks=new FavoriteBooks();
        return favoriteBooks.insertar("(idlibro, idusuario) values(?,?)", idLibro, idUsuario);
    }
    public boolean deleteFavoriteBook(int id_favorito){
        return new FavoriteBooks().borrar("id_favorito=?", id_favorito);
    }



}
