package com.example.artists.servlets;

import com.example.artists.model.Pista;
import com.example.artists.services.ServicioPista;
import com.example.artists.views.VistaPista;

// removed unused import warnings
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.util.List;

@WebServlet("/pistas")
public class PistaServlet extends HttpServlet {

    private ServicioPista servicioPista;
    private VistaPista view = new VistaPista();

    @Override
    public void init(){
        ApplicationContext context =
                WebApplicationContextUtils
                        .getWebApplicationContext(getServletContext());

        servicioPista = context.getBean(ServicioPista.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        List<Pista> pistas = servicioPista.listarTodos();
        String html = view.listarPistas(pistas, null);


        response.setContentType("text/html");
        response.getWriter().write(html);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String action = request.getParameter("action");
        Pista pistaEncontrada = null;

        if("crear".equals(action)){
            String titulo = request.getParameter("titulo");
            String genero = request.getParameter("genero");
            double duracion = Double.valueOf(request.getParameter("duracion"));
            String album = request.getParameter("album");
            servicioPista.agregarPista(titulo,genero,duracion,album);
        }

        if("eliminar".equals(action)){
            long id = Long.parseLong(request.getParameter("id"));
            servicioPista.eliminarPista(id);
        }

        if("buscar".equals(action)){
            long id = Long.parseLong(request.getParameter("id"));
            pistaEncontrada = servicioPista.buscarPorId(id);
        }

        List<Pista> pistas = servicioPista.listarTodos();
        String html = view.listarPistas(pistas, pistaEncontrada);

        response.setContentType("text/html");
        response.getWriter().write(html);

    }
}
