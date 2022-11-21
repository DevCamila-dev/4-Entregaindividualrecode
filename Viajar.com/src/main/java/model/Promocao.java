package model;

public class Promocao {
	
	private int idPromo;
	private String nome;
	private String valorPromo;
	private int idDestino;
	
	public int getIdPromo() {
		return idPromo;
	}
	public void setIdPromo(int idPromo) {
		this.idPromo = idPromo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValorPromo() {
		return valorPromo;
	}
	public void setValorPromo(String valorPromo) {
		this.valorPromo = valorPromo;
	}
	public int getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}
	
	@Override
	public String toString() {
		return "Promocao [idPromo=" + idPromo + ", nome=" + nome + ", valorPromo=" + valorPromo + ", idDestino="
				+ idDestino + "]";
	}

	

}
