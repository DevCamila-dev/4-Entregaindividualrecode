package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLconnection {
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agencia";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Cami1933#";
	
    public static Connection createConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver encontrado!");
			
		} catch(ClassNotFoundException e) {
			System.out.println("Driver não encontrado. " + e.getMessage());
		}
		
		try {
			Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			System.out.println("Conectado ao Banco de dados");
			return connection;
			
		} catch(SQLException e) {
			System.out.println("Não conectado ao Banco de dados." + e.getMessage());
			return null;
		}
	}

}
