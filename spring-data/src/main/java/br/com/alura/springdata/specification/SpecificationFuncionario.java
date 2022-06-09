package br.com.alura.springdata.specification;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.springdata.orm.Funcionario;

public class SpecificationFuncionario {
	// A feature que o Spring Data utiliza para fazer Querys dinâmicas se chama
		// Specification.
		// Dentro da Specification ela já abstrai todos aqueles códigos que vimos lá no
		// modelo do JPA
	
	public static Specification<Funcionario> nome(String nome){
		
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}

	public static Specification<Funcionario> cpf(String cpf){
		
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"), cpf);
	}
	
	public static Specification<Funcionario> salario(BigDecimal salario){
		
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("salario"), salario);
	}
	
	public static Specification<Funcionario> dataContratação(LocalDate dataContratação){
		
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("dataContratação"), dataContratação);
	}
}
