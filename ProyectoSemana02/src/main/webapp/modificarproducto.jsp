<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curso.model.Producto"
		 import="java.util.List"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ModificarPrecios</title>
<style>
table{border: 1px solid #000000}
th{border: 1px solid #000000; text-align:center}
td{border: 1px solid #000000; text-align:center}
</style>
</head>
<body>
	<h1>Modificar precio productos</h1>
	<p>Deber&aacute; introducir primero el precio deseado y a continuacion seleccionar el producto al que asignar ese precio </p>
<%
HttpSession tiendaSession = request.getSession(true);
List<Producto> inventario = (List<Producto>) tiendaSession.getAttribute("inventario");
%>
	<form action="ModificarProducto" method="post">
		<div class="form-group">
			<label for="nuevoPrecio">Inserte aqui el nuevo precio: </label><br>
			<input id="nuevoPrecio" type="number" name="nuevoPrecio" class="form-control" required>
		</div><br>

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
				<td><input type="submit" name="idMod" value="Modificar <%=i%>"></td>
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