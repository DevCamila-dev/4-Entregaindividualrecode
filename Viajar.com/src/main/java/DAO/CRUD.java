package DAO;

import java.util.List;

import model.Destino;

public interface CRUD {
	
	public static void create(Destino destino) {};
	public static void delete(int destinoId) {};
	public static List<Destino> find(String pesquisa){return null;}
	public static Destino findById(int destinoId) {return null;}
	public static void update(Destino destino) {}

}
