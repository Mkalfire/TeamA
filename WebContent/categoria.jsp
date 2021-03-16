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
    <link rel="stylesheet" href="css/estilos.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="contenedor">
<%@ include file="includes/header.jsp" %>

<%@ include file="includes/nav.jsp"%>

<section>


<% 
String id = "0";
		if (request.getAttribute("id") != null) {
		id = request.getAttribute("id").toString();
	}
	Categoria c = new Categoria();
	c.buscarID(Integer.parseInt(id));


%>
<h2>Insertar Categoría</h2>
<div class="formulario2" id="formu">

	<form  name="categoria" action="AltaCategoria" method="get" enctype="multipart/form-data">
	
	<li><label>Nombre</label><input type="text" name="nombre" class="titu2"  value="<%if(request.getAttribute("id")!=null)out.print(c.getNombre()); %>" id="nombre">
	<li><label>Descripción:</label><textarea name="descripcion" id="descripcion"><%  if(request.getAttribute("id")!=null)out.print(c.getDescripcion());%></textarea></li>
	<input type="hidden" name="id" id="id" value='<% if(request.getAttribute("id")!=null)
	out.print(c.getId());else out.print(0);%>'>
	<input type="hidden" name="opcion" value="1">
	<input type="submit" value="enviar">
	
	
	
	</form>
</div>


</section>

<%@ include file="includes/footer.jsp" %>

</div>

</body>
</html>