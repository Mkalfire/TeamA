package modelo;

import java.sql.SQLException;

import dao.DaoTarea;

public class Tarea {
	private int id;
	private String titulo;
	private String descripcion;
	private int categoria;
	private int importancia;
	private int dependencia;
	private String f_inicio;
	private String f_final;
	private int estado;
	public Tarea() {
		
	}
	
	public Tarea(String titulo, String descripcion, int categoria, int importancia, int dependencia,String f_inicio, String f_final, int estado) {
		
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.importancia = importancia;
		this.dependencia = dependencia;
		this.f_inicio = f_inicio;
		this.f_final = f_final;
		this.estado = estado;
	}




	public Tarea(int id,String titulo, String descripcion, int categoria,int importancia,int dependencia,String f_inicio, String f_final,int estado) {
	
		this.id=id;
		this.titulo=titulo;
		this.descripcion=descripcion;
		this.categoria=categoria;
		this.importancia=importancia;
		this.dependencia=dependencia;
		this.f_inicio = f_inicio;
		this.f_final = f_final;
		this.estado=estado;
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
	
	
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getImportancia() {
		return importancia;
	}
	public void setImportancia(int importancia) {
		this.importancia = importancia;
	}
	
	
	public int getDependencia() {
		return dependencia;
	}
	public void setDependencia(int dependencia) {
		this.dependencia = dependencia;
	}
	
	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	public void insertar() {
		
		try {
			DaoTarea.getInstance().insert(this);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", categoria=" + categoria
				+ ", importancia=" + importancia + ", dependencia=" + dependencia + ", f_inicio=" + f_inicio
				+ ", f_final=" + f_final + ", estado=" + estado + "]";
	}


}