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

		PreparedStatement ps= con.prepareStatement("INSERT INTO TareaP"
				+ "(titulo,descripcion,f_inicio,f_final,categoria) VALUES"
				+ "(?,?,?,?,?)");
		ps.setString(1, t.getTitulo());
		ps.setString(2, t.getDescripcion());
		ps.setString(3, t.getF_inicio());
		ps.setString(4, t.getF_final());
		ps.setInt(5, t.getCategoria());

		System.out.println(ps);
		ps.executeUpdate();
		ps.close();
	}
	
	public ArrayList <Tarea> listaTareas() throws SQLException{
		//ResultSet método parecido al arraylist pero de jdbc
			PreparedStatement ps= con.prepareStatement("SELECT * FROM TareaP");
			ResultSet resultado = ps.executeQuery();	
			ArrayList<Tarea>lista= null;
			lista= new ArrayList<>();
			while(resultado.next()) {
			
				//creo que si creas el ArrayList lista dentro del while, cuando quiere cargar el segundo 
				//sobreescribe el primero y por eso cuando imprimes te aparece el último.
			      lista.add(new Tarea(resultado.getInt("id"),resultado.getString("titulo"),resultado.getString("descripcion"),resultado.getString("f_inicio")
			    		  , resultado.getString("f_final"), resultado.getInt("categoria")
			    		  ));				
		
			}
			System.out.println(lista.size());
			resultado.close();
			ps.close();
		
			System.out.println(lista);
		return lista;
		
		
		
	}
	
	public Tarea busarId(int id) throws SQLException {
		
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM TareaP WHERE id = ?");
		
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Tarea result = null;
		if(rs.next()) {
			result = new Tarea(rs.getInt("id"), rs.getString("titulo"), rs.getString("descripcion"),
					rs.getString("f_inicio")
		    		  , rs.getString("f_final"),  rs.getInt("categoria"));				
		}
		rs.close();
		ps.close();
		return result;
		
		
	}
	
	public void update(Tarea t) throws SQLException {
		
		if(t.getId()==0) {
			return ;
		}
		
		PreparedStatement ps = con.prepareStatement("UPDATE TareaP SET titulo = ?, descripcion = ?, f_inicio = ?, f_final = ?, categoria = ? WHERE id = ?");
		
			
			ps.setString(1, t.getTitulo());
			ps.setString(2, t.getDescripcion());
			ps.setString(3, t.getF_inicio());
			ps.setString(4, t.getF_final());
			ps.setInt(5, t.getCategoria());
			ps.setInt(6, t.getId());
			ps.executeUpdate();
			ps.close();

	}
	
	
	public void delete(Tarea t) throws SQLException {
		
		delete(t.getId());
		
	}
	public void delete(int id) throws SQLException {
		if (id <= 0)
			return;

		PreparedStatement ps = con.prepareStatement("DELETE FROM TareaP WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}

}
