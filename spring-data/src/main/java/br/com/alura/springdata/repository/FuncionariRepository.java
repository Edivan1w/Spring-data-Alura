package br.com.alura.springdata.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.orm.FuncionarioProjecao;

@Repository
public interface FuncionariRepository extends PagingAndSortingRepository<Funcionario, Integer> 
     //JpaSpecificationExecutor porque essa interface vai ser responsável por executar as Specifications dentro do nosso Repository
     , JpaSpecificationExecutor<Funcionario>{

	List<Funcionario> findByNome(String nome);

	@Query("SELECT f FROM Funcionario f WHERE f.nome= :nome AND f.salario= :salario AND f.dataContratação= :dataContratacao")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate dataContratacao);

	@Query(value = "SELECT f FROM Funcionario f WHERE f.dataContratacao=> :data", nativeQuery = true)
	List<Funcionario> buscarPorDataMaior(LocalDate data);

	// essa é umas das feature dos sprin data ele trabalha com projeções.
	@Query(value = "SELECT f.id, f.nome, f.salario FROM funcionarios f ", nativeQuery = true)
	List<FuncionarioProjecao> findFuncionarioSalario();

	// A feature que o Spring Data utiliza para fazer Querys dinâmicas se chama
	// Specification.
	// Dentro da Specification ela já abstrai todos aqueles códigos que vimos lá no
	// modelo do JPA

}
