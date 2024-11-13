<%@page import="beans.Odontologo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Editar Odontologo

<%
String url = "http://localhost:8080/Practica/";

Odontologo odontologo;

if(request.getAttribute("odontologo")==null){
	odontologo=new Odontologo();
}else{
	
	odontologo= (Odontologo)request.getAttribute("odontologo");
}

%>

<form role="form" action="<%=url%>odontoController?op=modificar"
		method="POST">
		
	    

		ID<input type="hidden"  value="<%=odontologo.getId()%>" id="id" name="id"><br> <br>
		Ingrese Nombre: <input type="text"  value="<%=odontologo.getNombre()%>"  name="nombre" id="nombre"><br>
		<br> Apellidos: <input type="text" value="<%=odontologo.getApellido() %>"   name="apellido" id="apellido"><br>
		<br> Dni: <input type="text"  value="<%=odontologo.getDni()%>"  name="dni" id="dni"><br>
		<br> Fecha: <input type="text" value="<%=odontologo.getFechaN()%>"  name="fecha" id="fecha"><br>
		<br> Direccion: <input type="text" value="<%=odontologo.getDireccion() %>"  name="direccion"
			id="direccion"><br> <br> <input type="submit"
			name="guardar" id="guardar" value="Guardar"><br> <br>
		<a href="<%=url%>odontoController?op=listar">Volver</a>



	</form>










</body>
</html>