package com.curso.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.curso.model.Producto;

/**
 * Servlet implementation class Redirect
 */
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("option");
		HttpSession tiendaSession = request.getSession(true);
		
		List<Producto> inventario = (List<Producto>) tiendaSession.getAttribute("inventario");
		
		if(opcion.equals("search")) {
			if(inventario == null || inventario.isEmpty()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("InventarioVacioError.html");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("busqueda.html");
				dispatcher.forward(request, response);
			}
		}
		if(opcion.equals("add")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("insertarproducto.html");
			dispatcher.forward(request, response);
		}
		if(opcion.equals("delete")) {
			if(inventario == null || inventario.isEmpty()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("InventarioVacioError.html");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("eliminarproducto.jsp");
				dispatcher.forward(request, response);
			}
		}
		if(opcion.equals("mod")) {
			if(inventario == null || inventario.isEmpty()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("InventarioVacioError.html");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("modificarproducto.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
