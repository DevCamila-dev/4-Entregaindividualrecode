package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BD.MySQLconnection;
import model.Destino;

public class DestinoDAO implements CRUD {
	
	private static Connection connection = MySQLconnection.createConnection();
	private static String sql;
	
	public static void create(Destino destino) {
		 sql = "INSERT INTO destinos VALUES (null, ?, ?, ?, ?, ?, ?)";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, destino.getNome());
			 preparedStatement.setString(2, destino.getEstado());
			 preparedStatement.setString(3, destino.getPais());
			 preparedStatement.setString(4, destino.getDataIda());
			 preparedStatement.setString(5, destino.getDataVolta());
			 preparedStatement.setString(6, destino.getValor());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--Destino inserido no Banco de dados");
			 
		 } catch(SQLException e) {
			 System.out.println("--Ops! O destino não foi inserido no Banco de dados. " + e.getMessage());
		 }
	}
	
	public static void delete(int destinoId) {
		sql = "DELETE FROM destinos WHERE idDestino = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, destinoId);
			preparedStatement.executeUpdate();
			
			System.out.println("--O destino foi deletado");
			
		} catch (SQLException e) {
			System.out.println("--Ops! O destino não pôde ser deletado. " + e.getMessage());
		}
	}
	
	public static List<Destino> find(String pesquisa){
		
		sql = String.format("SELECT * FROM destinos WHERE nome like '%s%%' OR idDestino LIKE '%s%%' ", pesquisa, pesquisa);
		List<Destino> destinos = new ArrayList<Destino>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Destino destino = new Destino();
				
				destino.setIdDestino(resultSet.getInt("idDestino"));
				destino.setNome(resultSet.getString("nome"));
				destino.setEstado(resultSet.getString("estado"));
				destino.setPais(resultSet.getString("pais"));
				destino.setDataIda(resultSet.getString("dataIda"));
				destino.setDataVolta(resultSet.getString("dataVolta"));
				destino.setValor(resultSet.getString("valor"));
				
				destinos.add(destino);
				
			}
			
			System.out.println("--Destinos encontrados com sucesso");
			return destinos;
			
		} catch(SQLException e) {
			System.out.println("--Ops! Os destinos não foram encontrados. " + e.getMessage());
			return null;
		}
		
		
	}
	
	public static Destino findById(int destinoId) {
		sql = String.format("SELECT * FROM destinos WHERE idDestino = %d ", destinoId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Destino destino = new Destino();
			
			while (resultSet.next()) {
				destino.setIdDestino(resultSet.getInt("idDestino"));
				destino.setNome(resultSet.getString("nome"));
				destino.setEstado(resultSet.getString("estado"));
				destino.setPais(resultSet.getString("pais"));
				destino.setDataIda(resultSet.getString("dataIda"));
				destino.setDataVolta(resultSet.getString("dataVolta"));
				destino.setValor(resultSet.getString("valor"));
			}
			
			System.out.println("--Destinos encontrados por ID");
			return destino;
			
	} catch(SQLException e) {
		
			System.out.println("--Ops! Os Destinos não encontrados por ID. " + e.getMessage());
			return null;
		}
	}
	
	public static void update(Destino destino) {
		sql = "UPDATE destinos SET nome = ?, estado = ?, pais = ?, dataIda = ?, dataVolta = ?, valor = ? WHERE idDestino = ?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, destino.getNome());
			 preparedStatement.setString(2, destino.getEstado());
			 preparedStatement.setString(3, destino.getPais());
			 preparedStatement.setString(4, destino.getDataIda());
			 preparedStatement.setString(5, destino.getDataVolta());
			 preparedStatement.setInt(6, destino.getIdDestino());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--Banco de dados atualizado!");
			 
		 } catch(SQLException e) {
			 System.out.println("--Ops! O banco de dados não pôde ser atualizado. " + e.getMessage());
		 }
	}

}
