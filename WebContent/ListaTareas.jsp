<%@page import="modelo.ListaTareas"%>
<%@page import="modelo.Tarea"%>
<%@page import="modelo.Categoria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/estilos2.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="contenedor">
<%@ include file="includes/header.jsp" %>

<%@ include file="includes/nav.jsp"%>

<section>

<ul>
<%   
ListaTareas lista = new ListaTareas();
Categoria c= new Categoria();


for(Tarea t: lista.ObtenerlistaTareas()){
	out.print("<div class='caja'>");
	out.print("<li>"+"<h4>"+t.getTitulo()+"</h4>"+"</li>");
	out.print("<li>"+"<i><b>"+"Descripción: "+"</i></b>"+t.getDescripcion()+"</li>");
	out.print("<li>"+"<i><b>"+"Fecha de inicio: "+"</i></b>"+(String)t.getF_inicio()+"</li>");
	out.print("<li>"+"<i><b>"+"Fecha de finalización: "+"</i></b>"+(String)t.getF_final()+"</li>");
	out.print("<li>"+"<i><b>"+"Categoria:"+"</i></b>"+t.getCategoria()+"</li>");
	out.print("</div>");
	out.print("<div class='icons'>");
	out.print("<a href='AltaTarea?opcion=2&id="+t.getId()+"'>"+"<img src='img/editar.png'>"+"</a>");
	out.print("<a href='AltaTarea?opcion=3&id="+t.getId()+"'>"+"<img src='img/borrar.png'>"+"</a>");	
	out.print("</div>");

	
}

%>
</ul>


</section>

<%@ include file="includes/footer.jsp" %>

</div>

</body>
</html>