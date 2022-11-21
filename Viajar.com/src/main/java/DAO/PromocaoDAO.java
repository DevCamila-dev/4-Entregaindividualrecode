package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BD.MySQLconnection;
import model.Promocao;

public class PromocaoDAO implements CRUD1 {
	
	private static Connection connection = MySQLconnection.createConnection();
	private static String sql;
	
	public static void create(Promocao promocao) {
		 sql = "INSERT INTO promocoes VALUES (null, ?, ?, ?)";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, promocao.getNome());
			 preparedStatement.setString(2, promocao.getValorPromo());
			 preparedStatement.setInt(3, promocao.getIdDestino());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--Promoção inserida no Banco de dados");
			 
		 } catch(SQLException e) {
			 System.out.println("--Ops! A promoção não foi inserida no Banco de dados. " + e.getMessage());
		 }
	}
	
	public static void delete(int promoId) {
		sql = "DELETE FROM promocoes WHERE idPromo = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, promoId);
			preparedStatement.executeUpdate();
			
			System.out.println("--A promoção foi deletada");
			
		} catch (SQLException e) {
			System.out.println("--Ops! A promoção não pôde ser deletada. " + e.getMessage());
		}
	}
	
	public static List<Promocao> find(String pesquisa){
		
		sql = String.format("SELECT * FROM promocoes WHERE nome like '%s%%' OR idPromo LIKE '%s%%' ", pesquisa, pesquisa);
		List<Promocao> promocoes = new ArrayList<Promocao>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Promocao promocao = new Promocao();
				
				promocao.setIdPromo(resultSet.getInt("idPromo"));
				promocao.setNome(resultSet.getString("nome"));
				promocao.setValorPromo(resultSet.getString("valorPromo"));
				promocao.setIdDestino(resultSet.getInt("idDestino"));
				
				promocoes.add(promocao);
				
			}
			
			System.out.println("--Promoções encontradas com sucesso");
			return promocoes;
			
		} catch(SQLException e) {
			System.out.println("--Ops! As promoções não foram encontradas. " + e.getMessage());
			return null;
		}
		
		
	}
	
	public static Promocao findById(int promoId) {
		sql = String.format("SELECT * FROM promocoes WHERE idPromo = %d ", promoId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Promocao promocao = new Promocao();
			
			while (resultSet.next()) {
				promocao.setIdPromo(resultSet.getInt("idPromo"));
				promocao.setNome(resultSet.getString("nome"));
				promocao.setValorPromo(resultSet.getString("valorPromo"));
				promocao.setIdDestino(resultSet.getInt("idDestino"));
			}
			
			System.out.println("--Promoções encontradas por ID");
			return promocao;
			
	} catch(SQLException e) {
		
			System.out.println("--Ops! Promoções não encontradas por ID. " + e.getMessage());
			return null;
		}
	}
	
	public static void update(Promocao promocao) {
		sql = "UPDATE promocoes SET nome = ?, valorPromo = ?, idDestino = ? WHERE idPromo = ?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, promocao.getNome());
			 preparedStatement.setString(2, promocao.getValorPromo());
			 preparedStatement.setInt(3, promocao.getIdDestino());
			 preparedStatement.setInt(4, promocao.getIdPromo());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--Banco de dados atualizado!");
			 
		 } catch(SQLException e) {
			 System.out.println("--Ops! O banco de dados não pôde ser atualizado. " + e.getMessage());
		 }
	}

}
