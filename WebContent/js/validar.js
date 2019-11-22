


function validacion() {
	
	var titu= document.tarea;
	var ok=true;
	if(titu.titulo.value){
		  titu.titulo.style.backgroundColor = "#BCF5A9";
	ok=true;
	}else{
		 titu.titulo.style.backgroundColor = "#F5A9A9";
		 ok=false;
	}
	
	
	if(titu.descripcion.value){
		  titu.descripcion.style.backgroundColor = "#BCF5A9";
	}else{
		 titu.descripcion.style.backgroundColor = "#F5A9A9";
		 ok=false;
	}
	

	if(titu.f_inicio.value){
		  titu.f_inicio.style.backgroundColor = "#BCF5A9";
	}else{
		 titu.f_inicio.style.backgroundColor = "#F5A9A9";
		 ok=false;
	}
	

	if(titu.f_final.value){
		  titu.f_final.style.backgroundColor = "#BCF5A9";
	}else{
		 titu.f_final.style.backgroundColor = "#F5A9A9";
		 ok=false;
	}
	
	if(titu.categoria.value){
		 titu.categoria.style.backgroundColor = "#BCF5A9";
	}else{
		 titu.categoria.style.backgroundColor = "#F5A9A9";
		var txt="";
		txt+="<a href='categoria.jsp'>Insertar categoria</a>"
		document.getElementById("boton").innerHTML=txt;
		ok=false;
		
		
	}
	
	
	
	
	
	
		
	if(ok){
		titu.submit();
	}
}