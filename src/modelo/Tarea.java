package modelo;

import java.sql.SQLException;

import dao.DaoTarea;

public class Tarea {
	private int id;
	private String titulo;
	private String descripcion;
	private String f_inicio;
	private String f_final;
	private int categoria;


	public Tarea() {
		
	}
	
	public Tarea(String titulo, String descripcion,String f_inicio, String f_final, int categoria) {
		
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.f_inicio=f_inicio;
		this.f_final=f_final;
		this.categoria=categoria;

	}




public Tarea(int id,String titulo, String descripcion,String f_inicio, String f_final, int categoria) {
		this.id=id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.f_inicio=f_inicio;
		this.f_final=f_final;
		this.categoria=categoria;
	
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	
	public String getF_inicio() {
		return f_inicio;
	}

	public void setF_inicio(String f_inicio) {
		this.f_inicio = f_inicio;
	}

	public String getF_final() {
		return f_final;
	}

	public void setF_final(String f_final) {
		this.f_final = f_final;
	}
	

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	

	public void insertar() {
		
		try {
			DaoTarea.getInstance().insert(this);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void buscarID(int id) {
		
		Tarea e = null;
		try {
			e = DaoTarea.getInstance().busarId(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			this.id = e.getId();
			this.titulo = e.getTitulo();
			this.descripcion = e.getDescripcion();
			this.f_inicio=e.getF_inicio();
			this.f_final=e.getF_final();
			this.categoria=e.getCategoria();
			
		
		}
	}
	
	public void actualizar() {
		try {
			DaoTarea.getInstance().update(this);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	public void borrar() {
		try {
			DaoTarea.getInstance().delete(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Tarea [titulo=" + titulo + ", descripcion=" + descripcion + ", f_inicio=" + f_inicio + ", f_final="
				+ f_final + ", categoria=" + categoria + "]";
	}
	

	
	

	

}