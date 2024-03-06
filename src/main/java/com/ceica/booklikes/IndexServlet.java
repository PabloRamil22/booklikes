package com.ceica.booklikes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "indexServlet", value = "")

public class IndexServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<LibrosDTO> list =new ArrayList<>();
        LibrosDTO librosDTO =new LibrosDTO();
        librosDTO.setTitulo("asdf");
        librosDTO.setDescripcion("años 20");
        librosDTO.setFavoritos(3);
        librosDTO.setAutor("rosalia de castro");
        librosDTO.setId(2);
        list.add(librosDTO);


        request.setAttribute("listaLibros",list);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }


    }
