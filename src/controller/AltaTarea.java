package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Tarea;

/**
 * Servlet implementation class AltaTarea
 */
@WebServlet("/AltaTarea")
public class AltaTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaTarea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String titulo= request.getParameter("titulo");
		String descripcion=request.getParameter("descripcion");
		int categoria= Integer.parseInt(request.getParameter("categoria"));
		int importancia=Integer.parseInt(request.getParameter("importancia"));
		int dependencia=Integer.parseInt(request.getParameter("dependencia"));
		String f_inicio =request.getParameter("f_inicio");
		String f_final =request.getParameter("f_final");
		int estado=Integer.parseInt(request.getParameter("estado"));
		
		Tarea t= new Tarea();
		t.setTitulo(titulo);
		t.setDescripcion(descripcion);
		t.setCategoria(categoria);
		t.setImportancia(importancia);
		t.setDependencia(dependencia);
		t.setF_inicio(f_inicio);
		t.setF_final(f_final);
		t.setEstado(estado);
		t.insertar();
		response.sendRedirect("ListaTareas.jsp");

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
