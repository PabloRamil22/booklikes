package com.ceica.booklikes.models;

import com.ceica.booklikes.dto.BookDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book extends ModeloBase{

    private int idLibro;
    private String autor;
    private String titulo;
    private Date fecha_creacion;

    private String descripcion;

    private int id_usuario;

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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
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

    public List<BookDto> getallFavoriteBooks() {
        Book book= new Book();
        List<BookDto>bookDtoList = new ArrayList<>();
        Connection conn= book.getConnection();
        String sql="select  count(*) as favoritos, l.autor, l.titulo, li.idlibro from libros as l inner join libros_favoritos as li on l.idlibro = li.idlibro\n" +
                " group by li.idlibro,l.titulo;";
        try {
            Statement st= conn.createStatement();
            ResultSet resultSet=st.executeQuery(sql);
            while (resultSet.next()){
                BookDto bookDto1=new BookDto();
                bookDto1.setIdLibro(resultSet.getInt("li.idlibro"));
                bookDto1.setAutor(resultSet.getString("l.autor"));
                bookDto1.setTitulo(resultSet.getString("l.titulo"));
                bookDto1.setFavoritos(resultSet.getInt("favoritos"));
                bookDtoList.add(bookDto1);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return bookDtoList;
    }

    private List<Book> readResulSet(ResultSet resultSet) throws SQLException {
        List<Book> bookDtoList= new ArrayList<>();
        while (resultSet.next()){
        BookDto bookDto=new BookDto();


        }
        return bookDtoList;
    }

    public  List<Book> getAllBooks(){
        Book book = new Book();
        List<Book>bookList = new ArrayList<>();
        Connection conn = book.getConnection();
        String sql = "select idlibro, titulo, autor,descripcion\n" +
                "from libros;";
        try {
            Statement stm = conn.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);
            while(resultSet.next()){
                Book book1 = new Book();
                book1.setIdLibro(resultSet.getInt("idlibro"));
                book1.setTitulo(resultSet.getString("titulo"));
                book1.setTitulo(resultSet.getString("autor"));
                book1.setDescripcion(resultSet.getString("descripcion"));
                bookList.add(book1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }
}
