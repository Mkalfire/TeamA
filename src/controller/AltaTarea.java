package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void todo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	switch (request.getParameter("opcion")) {
    	
    	case "1":{
    		NuevaTarea(request, response);
    		break;
    	}
    	case "2":{
    		buscarTarea(request, response);
    		break;
    	}
    	case "3":{
    		borrarTarea(request, response);
    	}
    	default:{
    		break;
    	}
		
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		todo(request, response);
		
		
	}
	
	private void borrarTarea(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Tarea t = new Tarea();
		t.buscarID(Integer.parseInt(request.getParameter("id")));
		t.borrar();
		response.sendRedirect("ListaTareas.jsp");

	}
	
	
	public void NuevaTarea(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String titulo= request.getParameter("titulo");
		String descripcion=request.getParameter("descripcion");
		String f_inicio =request.getParameter("f_inicio");
		String f_final =request.getParameter("f_final");
		int categoria = Integer.parseInt(request.getParameter("categoria"));

		Tarea t= new Tarea();
		
		t.setTitulo(titulo);
		t.setDescripcion(descripcion);
		t.setF_inicio(f_inicio);
		t.setF_final(f_final);
		t.setCategoria(categoria);
	
		if (Integer.parseInt(request.getParameter("id")) != 0) {
			int id = Integer.parseInt(request.getParameter("id"));
			t.setId(id);
			t.actualizar();
		} else
			
		t.insertar();
		
		response.sendRedirect("ListaTareas.jsp");
	}
	
	
	public void buscarTarea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id;

		if (Integer.parseInt(request.getParameter("id")) != 0) {
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			RequestDispatcher vista = request.getRequestDispatcher("tareas.jsp");
			vista.forward(request, response);
		} else {
			request.setAttribute("id", null);
			RequestDispatcher vista = request.getRequestDispatcher("tareas.jsp");
			vista.forward(request, response);
		}

		
		
	}
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/htmlUTF-8");
		this.todo(request, response);
	}

}
