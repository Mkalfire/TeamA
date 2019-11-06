package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BDconnection {
	
	private static final String JDBC_URL = "jdbc:mysql://halifaxtraining.es:3306/ciberkaos015";
	private static Connection instance=null;//por si hay otra conexión anterior a la nuestra
	
	private BDconnection() {
		//hola estoy doramio
	}
	
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			if(instance== null) {
				Properties props = new Properties();
				props.put("user", "uss015");
				props.put("password", "rana2019");
				instance= DriverManager.getConnection(JDBC_URL, props);
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return instance;
	}
	
	
}
