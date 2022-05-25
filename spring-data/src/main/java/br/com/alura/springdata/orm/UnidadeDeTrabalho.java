package br.com.alura.springdata.orm;

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
	@OneToOne(fetch = FetchType.LAZY)
	private Endeco endereco;
	
	public UnidadeDeTrabalho() {}

	public UnidadeDeTrabalho(String descricao, Endeco endereco) {
		this.descricao = descricao;
		this.endereco = endereco;
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

	public Endeco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endeco endereco) {
		this.endereco = endereco;
	}
	
	
	
}
