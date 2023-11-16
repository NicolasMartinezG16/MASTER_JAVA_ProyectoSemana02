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
 * Servlet implementation class AltaProducto
 */
public class AltaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String seccion = request.getParameter("seccion");
		double precio = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
				
		Producto producto = new Producto(nombre, seccion, precio, stock);
		
		HttpSession tiendaSession = request.getSession(true);
		
		List<Producto> inventario = new ArrayList<Producto>();
		
		if(tiendaSession.getAttribute("inventario") != null) {
			inventario = (List<Producto>) tiendaSession.getAttribute("inventario");
		}
		
		inventario.add(producto);
		
		tiendaSession.setAttribute("inventario", inventario);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Tablas 1-10</title>");
		out.println("<style>");
		out.println("table{border: 1px solid #000000;}");
		out.println("td{border: 1px solid #000000; text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h1 style=\"color:green\">Producto: " + nombre + " dado de alta con exito :)</h1>");
		out.println("<a href=\"Home.html\">Volver a inicio</a>");
		
		out.println("</body>");
		out.println("</html>");
	}
}
