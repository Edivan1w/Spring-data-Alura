package br.com.alura.springdata.orm;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UnidadeDeTrabalho {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	@Embedded
	private Endereco endereco;
	
	@Override
	public String toString() {
		return "UnidadeDeTrabalho [id=" + id + ", descricao=" + descricao + ", endereco=" + endereco +"]";
	}

	public UnidadeDeTrabalho() {}

	public UnidadeDeTrabalho(String descricao,String cidade, String estatdo) {
		this.descricao = descricao;
		Endereco endereco = new Endereco();
		endereco.setCidade(cidade);
		endereco.setEstado(estatdo);
		this.setEndereco(endereco);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
}
