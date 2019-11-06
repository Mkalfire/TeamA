package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.BDconnection;
import modelo.Tarea;

public class DaoTarea {
	
	private Connection con=null;
	public static DaoTarea instance=null;
	
	public DaoTarea() throws SQLException {
		con= BDconnection.getConnection();
		
	}
	
	public static DaoTarea getInstance() throws SQLException {
		if(instance==null) {
			
			instance= new DaoTarea();
		}
	return instance;
	}
	
	public void insert(Tarea t) throws SQLException {

		PreparedStatement ps= con.prepareStatement("INSERT INTO Tarea"
				+ "(titulo,descripcion,categoria,importancia,dependencia,estado) VALUES"
				+ "(?,?,?,?,?,?)");
		ps.setString(1, t.getTitulo());
		ps.setString(2, t.getDescripcion());
		ps.setInt(3, t.getCategoria());
		ps.setInt(4,t.getImportancia());
		ps.setInt(5,t.getDependencia());
		ps.setInt(6,t.getEstado());
		ps.executeUpdate();
		ps.close();
	}
	
	public ArrayList <Tarea> listaTareas() throws SQLException{
		//ResultSet método parecido al arraylist pero de jdbc
			PreparedStatement ps= con.prepareStatement("SELECT * FROM Tarea");
			ResultSet resultado = ps.executeQuery();	
			ArrayList<Tarea>lista= null;
			lista= new ArrayList<>();
			while(resultado.next()) {
			
				//creo que si creas el ArrayList lista dentro del while, cuando quiere cargar el segundo 
				//sobreescribe el primero y por eso cuando imprimes te aparece el último.
			      lista.add(new Tarea(resultado.getInt("id"),resultado.getString("titulo"),resultado.getString("descripcion"),
				     resultado.getInt("categoria"),resultado.getInt("importancia"),resultado.getInt("dependencia"),resultado.getInt("estado")));				
		
			}
			System.out.println(lista.size());
			resultado.close();
			ps.close();
		
			
		return lista;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
