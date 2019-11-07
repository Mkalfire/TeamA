<%@page import="modelo.ListaTareas"%>
<%@page import="modelo.Tarea"%>
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

<h2>Listaaaaa</h2>
<ul>
<%     
ListaTareas lista = new ListaTareas();

for(Tarea t: lista.ObtenerlistaTareas()){
	out.print("<div class='caja'>");
	out.print("<li>"+"<h4>"+t.getTitulo()+"</h4>"+"</li>");
	out.print("<li>"+"<i><b>"+"Descripción: "+"</i></b>"+t.getDescripcion()+"</li>");
	out.print("<li>"+"<i><b>"+"Categoría: "+"</i></b>"+t.getCategoria()+"</li>");
	out.print("<li>"+"<i><b>"+"Importancia: "+"</i></b>"+t.getImportancia()+"</li>");
	out.print("<li>"+"<i><b>"+"Dependencia: "+"</i></b>"+t.getDependencia()+"</li>");
	out.print("<li>"+"<i><b>"+"Estado: "+"</i></b>"+t.getEstado()+"</li>");
	out.print("</div>");
	
}

%>
</ul>


</section>

<%@ include file="includes/footer.jsp" %>

</div>

</body>
</html>