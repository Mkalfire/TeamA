package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoTarea;

public class ListaTareas {
	
	private ArrayList <Tarea> lista;
	
	public ArrayList <Tarea> ObtenerlistaTareas() {
		
		ArrayList<Tarea>lista=null;
		
		try {
			lista=DaoTarea.getInstance().listaTareas();		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
	}
	
	
	

}
