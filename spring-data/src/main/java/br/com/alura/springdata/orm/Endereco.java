package br.com.alura.springdata.orm;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Endereco {

	
	private String estado;
	private String cidade;
	
	public Endereco() {}
	public Endereco(String estado, String cidade) {
		this.estado = estado;
		this.cidade = cidade;
	}
	
	
	@Override
	public String toString() {
		return "Endeco [estado=" + estado + ", cidade=" + cidade + "]";
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
