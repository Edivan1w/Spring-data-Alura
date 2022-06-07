package br.com.alura.springdata.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springdata.orm.Funcionario;
@Repository
public interface FuncionariRepository extends PagingAndSortingRepository<Funcionario, Integer> {
	
	List<Funcionario> findByNome(String nome);

	@Query("SELECT f FROM Funcionario f WHERE f.nome= :nome AND f.salario= :salario AND f.dataContratação= :dataContratacao")
	List<Funcionario>findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate dataContratacao);
	
	@Query(value = "SELECT f FROM Funcionario f WHERE f.dataContratacao=> :data", nativeQuery = true)
	List<Funcionario> buscarPorDataMaior(LocalDate data);
	
}
