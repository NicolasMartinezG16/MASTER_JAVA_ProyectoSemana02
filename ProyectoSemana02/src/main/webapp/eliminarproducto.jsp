<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curso.model.Producto"
		 import="java.util.List"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EliminarProductos</title>
<style>
table{border: 1px solid #000000}
th{border: 1px solid #000000; text-align:center}
td{border: 1px solid #000000; text-align:center}
</style>
</head>
<body>
<h1>Eliminar productos</h1>
<%
HttpSession tiendaSession = request.getSession(true);
List<Producto> inventario = (List<Producto>) tiendaSession.getAttribute("inventario");
%>
<form action="EliminarProducto" method="post">
<table>
<tr>
<th>Aci&oacute;n</th>
<th>Nombre</th>
<th>Secci&oacute;n</th>
<th>Precio</th>
<th>Cantidad en stock</th>
</tr>
<%for(int i = 0; i < inventario.size(); i++){%>
	<tr>
	<td><input type="submit" name="idBorrada" value="Borrar <%=i%>"></td>
	<td><%=inventario.get(i).getNombre() %></td>
	<td><%=inventario.get(i).getSeccion() %></td>
	<td><%=inventario.get(i).getPrecio() %>€</td>
	<td><%=inventario.get(i).getStock() %></td>
	</tr>
<%} %>
</table>
</form>
</body>
</html>