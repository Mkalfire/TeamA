package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.BDconnection;
import modelo.Categoria;
import modelo.Tarea;

public class DaoCategoria {

	private Connection con=null;
	public static DaoCategoria instance=null;
	
	public DaoCategoria() throws SQLException {
		con= BDconnection.getConnection();
		
	}
	
	public static DaoCategoria getInstance() throws SQLException {
		if(instance==null) {
			
			instance= new DaoCategoria();
		}
	return instance;
	}
	
	public void insert(Categoria c) throws SQLException {

		PreparedStatement ps= con.prepareStatement("INSERT INTO categoriAA"
				+ "(nombre,descripcion) VALUES"
				+ "(?,?)");
		ps.setString(1, c.getNombre());
		ps.setString(2, c.getDescripcion());

		ps.executeUpdate();
		ps.close();
	}
	
	public ArrayList <Categoria> listaCategorias() throws SQLException{
		//ResultSet método parecido al arraylist pero de jdbc
			PreparedStatement ps= con.prepareStatement("SELECT * FROM categoriAA");
			ResultSet resultado = ps.executeQuery();	
			ArrayList<Categoria>lista= null;
			lista= new ArrayList<>();
			while(resultado.next()) {
			
				//creo que si creas el ArrayList lista dentro del while, cuando quiere cargar el segundo 
				//sobreescribe el primero y por eso cuando imprimes te aparece el último.
			      lista.add(new Categoria(resultado.getInt("id"),resultado.getString("nombre"),resultado.getString("descripcion")));				
		
			}	
			
			resultado.close();
			ps.close();
			
		return lista;
	}
	
	public Categoria buscarId(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM categoriAA WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Categoria result = null;
		if(rs.next()) {
			result = new Categoria(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"));				
		}
		rs.close();
		ps.close();
		return result;
		
	}
	
	public void update (Categoria ca) throws SQLException  {
		if(ca.getId()== 0) {
			return;
		}
		
		PreparedStatement ps = con.prepareStatement("UPDATE categoriAA SET nombre = ?, descripcion = ? WHERE id = ?");
	
			ps.setString(1, ca.getNombre());
			ps.setString(2, ca.getDescripcion());
			ps.setInt(3, ca.getId());
			ps.executeUpdate();
			ps.close();
	}
	
	
	public void delete(Categoria c) throws SQLException {
		
		delete(c.getId());
	}
	public void delete(int id) throws SQLException {
		if (id <= 0)
			return;

		PreparedStatement ps = con.prepareStatement("DELETE FROM categoriAA WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}
	
}
