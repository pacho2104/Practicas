<%@page import="model.odontologoModel"%>
<%@page import="beans.Odontologo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String url = "http://localhost:8080/PracticaA/";
	%>
	<a href="<%=url%>odontoController?op=nuevo">Nuevo Odontologo</a>


	<table border="1">

		<thead>

			<tr>


				<td>Id</td>
				<td>Nombre</td>
				<td>Apellido</td>
				<td>Dni</td>
				<td>Fecha Nacimiento</td>
				<td>Direccion</td>
				<td>Operaciones</td>



			</tr>


		</thead>

		<tbody>

			<%
			List<Odontologo> listaOdontologo = (List<Odontologo>) request.getAttribute("listaOdontologo");

			if (listaOdontologo != null) {

				for (Odontologo odon : listaOdontologo) {
			%>



			<tr>

				<td><%=odon.getId()%></td>
				<td><%=odon.getNombre()%></td>
				<td><%=odon.getApellido()%></td>
				<td><%=odon.getDni()%></td>
				<td><%=odon.getFechaN()%></td>
				<td><%=odon.getDireccion()%></td>

				<td><a type="button"
					href="<%=url%>odontoController?op=obtener&id=<%=odon.getId()%>">Modificar</a>
					<a type="button"
					href="<%=url%>odontoController?op=eliminar&id=<%=odon.getId()%>">Eliminar</a>



				</td>

			</tr>

			<%
			}
			} else {
			%>
			<tr>

				<td>No hay datos</td>
				<td>No hay datos</td>
				<td>No hay datos</td>
				<td>No hay datos</td>
				<td>No hay datos</td>
				<td>No hay datos</td>

			</tr>

			<%
			}
			%>




		</tbody>






	</table>






</body>
</html>