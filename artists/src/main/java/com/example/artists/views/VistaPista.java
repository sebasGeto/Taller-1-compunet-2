package com.example.artists.views;

import com.example.artists.model.Pista;

import java.util.List;

public class VistaPista {

    public String listarPistas(List<Pista> pistas, Pista pistaEncontrada) {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head>");
        builder.append("<style>");
        builder.append("body{background-color:lightyellow;font-family:Tahoma;}");
        builder.append("h2{color:darkblue;text-align:center;}");
        builder.append("table{width:100%;margin-bottom:15px;}");
        builder.append("</style>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<h2>Listado de Pistas</h2>");
        builder.append("<table border='1'>");
        builder.append("<tr><th>ID</th><th>Titulo</th><th>Genero</th><th>Duracion</th><th>Album</th><th>Eliminar</th></tr>");
        for (Pista p : pistas) {
            builder.append("<tr>");
            builder.append("<td>" + p.getId() + "</td>");
            builder.append("<td>" + p.getTitulo() + "</td>");
            builder.append("<td>" + p.getGenero() + "</td>");
            builder.append("<td>" + p.getDuracion() + "</td>");
            builder.append("<td>" + p.getAlbum() + "</td>");
            builder.append("<td><form method='post' style='display:inline;'><input type='hidden' name='id' value='" + p.getId() + "'/><input type='hidden' name='action' value='eliminar'/><input type='submit' value='Eliminar'/></form></td>");
            builder.append("</tr>");
        }
        builder.append("</table>");
        builder.append("<hr>");
        builder.append("<h3>Crear nueva pista</h3>");
        builder.append("<form method='post'>");
        builder.append("Titulo: <input type='text' name='titulo'/> <br><br>");
        builder.append("Genero: <input type='text' name='genero'/> <br><br>");
        builder.append("Duracion: <input type='text' name='duracion'/> <br><br>");
        builder.append("Album: <input type='text' name='album'/> <br><br>");
        builder.append("<input type='hidden' name='action' value='crear'/>");
        builder.append("<input type='submit' value='Guardar pista'/>");
        builder.append("</form>");
        builder.append("<hr>");
        builder.append("<h3>Buscar pista por ID</h3>");
        builder.append("<form method='post'>");
        builder.append("ID: <input type='number' name='id'/> ");
        builder.append("<input type='hidden' name='action' value='buscar'/>");
        builder.append("<input type='submit' value='Buscar'/>");
        builder.append("</form>");
        if (pistaEncontrada != null) {
            builder.append("<p><strong>Encontrado:</strong> Pista " + pistaEncontrada.getId() + " - " + pistaEncontrada.getTitulo() + " - " + pistaEncontrada.getGenero() + " - " + pistaEncontrada.getAlbum() + "</p>");
        }
        builder.append("</body>");
        builder.append("</html>");
        return builder.toString();
    }
}

