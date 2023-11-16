package com.curso.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.curso.model.Producto;

/**
 * Servlet implementation class EliminarProducto
 */
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession tiendaSession = request.getSession(true);
		int idBorrada = Integer.parseInt(request.getParameter("idBorrada").split(" ")[1]);
		
		List<Producto> inventario = (List<Producto>) tiendaSession.getAttribute("inventario");		

		String nombreBorrado = inventario.get(idBorrada).getNombre();
		
		inventario.remove(idBorrada);
		
		tiendaSession.setAttribute("inventario", inventario);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Tablas 1-10</title>");
		out.println("<style>");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h1 style=\"color:green\">Producto: " + nombreBorrado + " borrado con exito :)</h1>");
		out.println("<a href=\"Home.html\">Volver a inicio</a>");
		
		out.println("</body>");
		out.println("</html>");
	}
}
