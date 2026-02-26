package com.example.artists.servlets;

import com.example.artists.model.Artista;
import com.example.artists.model.Pista;
import com.example.artists.services.ServicioArtista;
import com.example.artists.services.ServicioPista;
import com.example.artists.views.VistaArtista;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/artistas")
public class ArtistaServlet extends HttpServlet {
    private ServicioArtista servicioArtista;
    private VistaArtista vista;
    private ServicioPista servicioPista;

    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        servicioArtista = context.getBean(ServicioArtista.class);
        servicioPista = context.getBean(ServicioPista.class);
        vista = new VistaArtista();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        List<Artista> artistas = servicioArtista.listarTodos();
        List<Pista> pistas = servicioPista.listarTodos();

        String html = vista.listarArtistas(artistas, pistas,null);

        response.setContentType("text/html");
        response.getWriter().write(html);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String action = request.getParameter("action");
        Artista artistaEncontrado = null;

        if("crear".equals(action)){

            String nombre = request.getParameter("nombreArtista");
            String nacionalidad = request.getParameter("nacionalidadArtista");
            String[] ids = request.getParameterValues("pistaIds");

            List<Long> pistaIds = new ArrayList<>();
            if(ids != null){
                for(String id : ids){
                    pistaIds.add(Long.parseLong(id));
                }
            }

            servicioArtista.agregarArtista(nombre, nacionalidad, pistaIds);
        }

        if("eliminar".equals(action)){
            long id = Long.parseLong(request.getParameter("id"));
            servicioArtista.eliminarArtista(id);
        }

        if("buscar".equals(action)){
            long id = Long.parseLong(request.getParameter("id"));
            artistaEncontrado = servicioArtista.buscarPorId(id);
        }

        if("actualizar".equals(action)){

            long id = Long.parseLong(request.getParameter("id"));
            String[] ids = request.getParameterValues("pistaIds");
            List<Long> pistaIds = new ArrayList<>();
            if(ids != null){
                for(String s : ids){
                    pistaIds.add(Long.parseLong(s));
                }
            }
            servicioArtista.actualizarPistasArtista(id, pistaIds);
        }

        List<Artista> artistas = servicioArtista.listarTodos();
        List<Pista> pistas = servicioPista.listarTodos();

        String html = vista.listarArtistas(artistas, pistas, artistaEncontrado);

        response.setContentType("text/html");
        response.getWriter().write(html);

    }
}

