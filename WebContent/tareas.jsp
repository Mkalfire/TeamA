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

<div class="formulario">
<h2>Insertar Tareas</h2>
<form name="tarea" action="AltaTarea" method="get">

<li><label>Título:</label><input type="text" name="titulo" class="titu"></li>
<li><label>Descripción:</label><textarea name="descripcion" ></textarea></li>
<li>
<label>Categoría:</label>
<select name="categoria" class="select0">
<option value="0">Letras</option>
<option value="1">Operaciones</option>
<option value="2">Idiomas</option>
<option value="3">Otro</option>
</select>
</li>
<li>
<label>Importancia:</label>
<select name="importancia" class="select1">
<option value="0">Nada</option>
<option value="1">Baja</option>
<option value="2">Media</option>
<option value="3">Importante</option>
</select>
</li>
<li>
<label>Pertenece a la tarea:</label>
<select name="dependencia" class="select2">
<option value="0">...</option>
<option value="1">Proyecto 5</option>
<option value="2"> Proyecto 6</option>
<option value="3">Proyecto 7</option>
</select>
</li>

<label>Estado:</label>
<select name="estado" class="select3">
<option value="0">...</option>
<option value="1">Sin empezar</option>
<option value="2">En espera</option>
<option value="3">En proceso </option>
<option value="4">Terminada </option>
</select>
</li>

<input type="submit" value="enviar">
</form>
</div>

</section>

<%@ include file="includes/footer.jsp" %>

</div>

</body>
</html>