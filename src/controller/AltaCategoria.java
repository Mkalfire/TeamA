package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;
import modelo.Tarea;

/**
 * Servlet implementation class AltaCategoria
 */
@WebServlet("/AltaCategoria")
public class AltaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		todo(request, response);
    }
	
	
	
	
	public void todo (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		switch (request.getParameter("opcion")) {
    	
    	case "1":{
    		nuevaCategoria(request, response);
    		break;
    	}
    	case "2":{
    		buscarCategoria(request, response);
    		break;
    	}
    	case "3":{
    		borrarTarea(request, response);
    		break;
    	}
    	default:{
    		break;
    	}
		
		}
		
	}
	
	public void nuevaCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String nombre= request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Categoria c = new Categoria();
		c.setNombre(nombre);
		c.setDescripcion(descripcion);
		
		if (Integer.parseInt(request.getParameter("id")) != 0) {
			int id = Integer.parseInt(request.getParameter("id"));
			c.setId(id);
			c.actualizar();
		} else
			
		c.insertar();
		response.sendRedirect("ListaCategorias.jsp");
		
		
		
	}
	
	
	public void buscarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id;

		if (Integer.parseInt(request.getParameter("id")) != 0) {
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			RequestDispatcher vista = request.getRequestDispatcher("categoria.jsp");
			vista.forward(request, response);
		} else {
			request.setAttribute("id", null);
			RequestDispatcher vista = request.getRequestDispatcher("categoria.jsp");
			vista.forward(request, response);
		}

		
		
	}
	
	private void borrarTarea(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Categoria c = new Categoria();
		c.buscarID(Integer.parseInt(request.getParameter("id")));
		c.borrar();
		response.sendRedirect("ListaCategorias.jsp");

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
