package com.curso.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.curso.model.Producto;

/**
 * Servlet implementation class BusquedaProducto
 */
public class BusquedaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seccion = request.getParameter("seccion");
		
		HttpSession tiendaSession = request.getSession(true);
		List<Producto> inventario = (List<Producto>) tiendaSession.getAttribute("inventario");
		
		List<Producto> inventarioFiltrado = inventario.stream()
                .filter(producto -> producto.getSeccion().equals(seccion)).toList();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>BusquedaProducto</title>");
		out.println("<style>");
		out.println("table{border: 1px solid #000000}");
		out.println("th{border: 1px solid #000000; text-align:center}");
		out.println("td{border: 1px solid #000000; text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		if(inventarioFiltrado.isEmpty()) {
			out.println("<h1 style=\"color:red\">No hay productos en la seccion: " + seccion + ":(</h1>");
			out.println("<a href=\"Home.html\">Volver a inicio</a><br>");
		}else {
			out.println("<h1 style=\"color:green\">Esta es la lista de todos los productos que pertenecen a la seccion: " + seccion + ":)</h1>");
			out.println("<a href=\"Home.html\">Volver a inicio</a><br>");
			
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Nombre</th>");
			out.println("<th>Precio</th>");
			out.println("<th>Cantidad en stock</th>");
			out.println("</tr>");
			for(int i = 0; i< inventarioFiltrado.size(); i++) {
				out.println("<tr>");
				out.println("<td>" + inventarioFiltrado.get(i).getNombre() + "</td>");
				out.println("<td>" + inventarioFiltrado.get(i).getPrecio() + "€</td>");
				out.println("<td>" + inventarioFiltrado.get(i).getStock() + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}
}
