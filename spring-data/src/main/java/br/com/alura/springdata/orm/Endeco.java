package br.com.alura.springdata.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endeco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String estado;
	private String cidade;
	
	public Endeco() {}
	public Endeco(String estado, String cidade) {
		this.estado = estado;
		this.cidade = cidade;
	}
	
	
	@Override
	public String toString() {
		return "Endeco [estado=" + estado + ", cidade=" + cidade + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	
}
