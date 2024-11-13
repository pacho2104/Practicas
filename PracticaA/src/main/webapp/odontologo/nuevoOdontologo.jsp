<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function validarFormulario() {

		const nombre = document.getElementById("nombre").value.trim();
		const apellido = document.getElementById("apellido").value.trim();
		const dni = document.getElementById("dni").value.trim();
		const fecha = document.getElementById("fecha").value.trim();
		const direccion = document.getElementById("direccion").value.trim();

		if (nombre === '') {

			alert("Ingrese nombre de odontologo");
			document.getElementById("nombre").value.trim();
			return false;

		}
		if (apellido === '') {

			alert("Ingrese apellido de odontologo");
			document.getElementById("apellido").value.trim();
			return false;

		}

		if (dni === '') {

			alert("Ingrese dni de odontologo");
			document.getElementById("dni").value.trim();
			return false;

		}

		if (fecha === '') {

			alert("Ingrese fecha de nacimiento de odontologo");
			document.getElementById("fecha").value.trim();
			return false;

		}

		if (direccion === '') {

			alert("Ingrese direccion de odontologo");
			document.getElementById("direccion").value.trim();
			return false;

		}

		return true;

	}
</script>






</head>
<body>

	<%
	String url = "http://localhost:8080/PracticaA/";
	%>



	<form role="form" action="<%=url%>odontoController?op=insertar"
		method="POST"  onsubmit="return validarFormulario()"  >

		<input type="hidden" id="id" name="id"><br> <br>
		Ingrese Nombre: <input type="text" name="nombre" id="nombre"><br>
		<br> Apellidos: <input type="text" name="apellido" id="apellido"><br>
		<br> Dni: <input type="text" name="dni" id="dni"><br>
		<br> Fecha: <input type="text" name="fecha" id="fecha"><br>
		<br> Direccion: <input type="text" name="direccion"
			id="direccion"><br> <br> <input type="submit"
			name="guardar" id="guardar" value="Guardar"><br> <br>
		<a href="<%=url%>odontoController?op=listar">Volver</a>



	</form>

	<%
	if (request.getAttribute("respuesta") != null) {

		boolean res = (boolean) request.getAttribute("respuesta");

		if (res) {
			List<String> listaError = (List<String>) request.getAttribute("listaError");

			for (String error : listaError) {
	%>
	<span><%=error%></span>
	<br>

	<%
	}
	}
	}
	%>





</body>
</html>