package model;

public class Destino {
	
	private int idDestino;
	private String nome;
	private String estado;
	private String pais;
	private String dataIda;
	private String dataVolta;
	private String valor;
	public int getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDataIda() {
		return dataIda;
	}
	public void setDataIda(String dataIda) {
		this.dataIda = dataIda;
	}
	public String getDataVolta() {
		return dataVolta;
	}
	public void setDataVolta(String dataVolta) {
		this.dataVolta = dataVolta;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Destino [idDestino=" + idDestino + ", nome=" + nome + ", estado=" + estado + ", pais=" + pais
				+ ", dataIda=" + dataIda + ", dataVolta=" + dataVolta + ", valor=" + valor + "]";
	}
	
	

}
