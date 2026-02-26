package com.example.artists.views;

import com.example.artists.model.Artista;
import com.example.artists.model.Pista;

import java.util.List;

public class VistaArtista {

    public String listarArtistas(List<Artista> artistas, List<Pista> pistas, Artista artistaEncontrado) {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head>");
        builder.append("<style>");
        builder.append("body { background-color: lightblue; font-family: Verdana; }");
        builder.append(".cabecera {text-align:center; color: darkslategray;}");
        builder.append("table {width:100%; margin-bottom:20px;}");
        builder.append("</style>");
        builder.append("</head>");
        builder.append("<body>");
        // tabla
        builder.append("<h2 class='cabecera'>Listado de Artistas</h2>");
        builder.append("<table border='1'>");
        builder.append("<tr><th>ID</th><th>Nombre</th><th>Nacionalidad</th><th>Pistas</th><th>Eliminar</th></tr>");
        for (Artista a : artistas) {
            builder.append("<tr>");
            builder.append("<td>" + a.getId() + "</td>");
            builder.append("<td>" + a.getNombre() + "</td>");
            builder.append("<td>" + a.getNacionalidad() + "</td>");
            builder.append("<td>");
            for (Pista p : a.getPistas()) {
                builder.append(p.getTitulo() + " (" + p.getAlbum() + ") ");
            }
            builder.append("</td>");
            builder.append("<td><form method='post' style='display:inline;'><input type='hidden' name='id' value='" + a.getId() + "'/><input type='hidden' name='action' value='eliminar'/><input type='submit' value='Eliminar'/></form></td>");
            builder.append("</tr>");
        }
        builder.append("</table>");
        builder.append("<hr>");
        // crear artista
        builder.append("<h3>Crear nuevo artista</h3>");
        builder.append("<form method='post'>");
        builder.append("Nombre: <input type='text' name='nombreArtista'/> <br><br>");
        builder.append("Nacionalidad: <input type='text' name='nacionalidadArtista'/> <br><br>");
        builder.append("Pistas:<br>");
        for (Pista p : pistas) {
            builder.append("<input type='checkbox' name='pistaIds' value='" + p.getId() + "'/> " + p.getTitulo() + "<br>");
        }
        builder.append("<input type='hidden' name='action' value='crear'/>");
        builder.append("<input type='submit' value='Guardar artista'/>");
        builder.append("</form>");
        builder.append("<hr>");
        // buscar
        builder.append("<h3>Buscar artista por ID</h3>");
        builder.append("<form method='post'>");
        builder.append("ID: <input type='number' name='id'/> ");
        builder.append("<input type='hidden' name='action' value='buscar'/>");
        builder.append("<input type='submit' value='Buscar'/>");
        builder.append("</form>");
        if (artistaEncontrado != null) {
            builder.append("<p><strong>Encontrado:</strong> Artista " + artistaEncontrado.getId() + " - " + artistaEncontrado.getNombre() + "<br>" + artistaEncontrado.getNacionalidad() + "<br>Pistas:<br>");
            for (Pista p : artistaEncontrado.getPistas()) {
                builder.append(p.getTitulo() + "<br>");
            }
            builder.append("</p>");
        }
        builder.append("</body>");
        builder.append("</html>");
        return builder.toString();
    }
}

