package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoTarea;

public class Categoria {

	private int id;
	private String nombre;
	private String descripcion;
	
	private ArrayList <Categoria> lista;
	
	public Categoria() {
		
	}

	public Categoria(int id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion= descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void insertar() {
		
		try {
			DaoCategoria.getInstance().insert(this);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	public void buscarID(int id) {
		
		Categoria c = null;
		try {
			c = DaoCategoria.getInstance().buscarId(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (c != null) {
			this.id = c.getId();
			this.nombre = c.getNombre();
			this.descripcion=c.getDescripcion();
		
		}
	}
	
	

	
	public ArrayList <Categoria> ObtenerListaCategoria() {
		
			ArrayList<Categoria>lista=null;
		
		try {
			lista=DaoCategoria.getInstance().listaCategorias();	
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
	}
	
	
	public void actualizar() {
		
		try {
			DaoCategoria.getInstance().update(this);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void borrar() {
	try {
		DaoCategoria.getInstance().delete(this);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}


	

	
	
}
