package DAO;

import java.util.List;

import model.Promocao;

public interface CRUD1 {
	
	public static void create(Promocao promocao) {};
	public static void delete(int promoId) {};
	public static List<Promocao> find(String pesquisa){return null;}
	public static Promocao findById(int promoId) {return null;}
	public static void update(Promocao promocao) {}

}
