
<%@page import="java.util.Formatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="sun.awt.SunHints.LCDContrastKey"%>
<%@page import="modelo.Tarea"%>
<%@page import="modelo.Categoria"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/estilos.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="js/validar.js" type="text/javascript"></script>

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
				Tarea t = new Tarea();
				Categoria c = new Categoria();
				
				
				
				t.buscarID(Integer.parseInt(id));
				c.buscarID(Integer.parseInt(id));
		
			%>

	
<div class="formulario" id="formu">
<h2>Insertar Tarea</h2>
<form name="tarea" action="AltaTarea" method="get" enctype="multipart/form-data">

<li><label>Título:</label><input type="text" name="titulo" id="titulo" class="titu" value='<% if(request.getAttribute("id")!=null)
out.print(t.getTitulo());%>'></li>

<li><label>Descripción:</label><textarea name="descripcion" id="descripcion"><%  if(request.getAttribute("id")!=null)out.print(t.getDescripcion());%></textarea></li>
<li>


<li><label>Fecha Inicio: </label><input type="date" id="f_inicio" class="fecha1" name="f_inicio" value='<% 
	
	if(request.getAttribute("id")!=null)out.print(t.getF_inicio());%>'></li>

<li><label>Fecha Final: </label><input type="date"  class="fecha2" name="f_final" id="f_final" value='<% if (request.getAttribute("id")!=null)out.print(t.getF_final());%>'></li>


<li>
<label>Categoría:</label>
<select name="categoria" id="categoria" class="select0">

		<%
		if(c.ObtenerListaCategoria().size()!=0){
			
			for(Categoria cate : c.ObtenerListaCategoria()){
				
				out.print(" <option value=" + cate.getId() + ">" + cate.getNombre() + "</option>");
			}
		}else{
			
			
		}	
		%>
	
</select>
</li>

<input type="hidden" name="id" id="id" value='<% if(request.getAttribute("id")!=null)
	out.print(t.getId());else out.print(0);%>'>
<input type="hidden" name="opcion" value="1">
<input type="button"  value="enviar" onclick="validacion()" >
<div id="boton"></div>

</form>
</div>

</section>

<%@ include file="includes/footer.jsp" %>
	
</div>

</body>
</html>