package br.com.alura.springdata.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.orm.FuncionarioProjecao;
import br.com.alura.springdata.orm.UnidadeDeTrabalho;
import br.com.alura.springdata.repository.CargoRepository;
import br.com.alura.springdata.repository.FuncionariRepository;
import br.com.alura.springdata.repository.UnidadeDeTrabalhoRepository;

@Service
public class FuncionarioService {

	
	private final FuncionariRepository funRepository;
	private final CargoRepository cargoRepository;
	private final UnidadeDeTrabalhoRepository utRepository;
	private boolean system = true;
	
	public FuncionarioService(FuncionariRepository repository, CargoRepository cargoRepository, UnidadeDeTrabalhoRepository utRepository) {
		this.funRepository = repository;
		this.cargoRepository = cargoRepository;
		this.utRepository = utRepository;
	}
	
	public void inicial(Scanner scanner) {
		
		while (system) {
			System.out.println("0 = sair");
			System.out.println("1 = salvar");
			System.out.println("2 = atualizar");
			System.out.println("3 = visualizar");
			System.out.println("4 = deletar");
			System.out.println("5 = visualizar funcionários com id, nome e sálário.");
		
			
			int action = scanner.nextInt();
			switch(action) {
			
			case 1: 
				salvar(scanner);
				break;
			
			case 2: 
				atualizar(scanner);
				break;
			
			case 3: 
				visualizar(scanner);
				break;
			
			case 4:  
				deletar(scanner);
				break;
				
			case 5: 
				visualizarSalioFuncionários();
				break;
		
				
			
			default:
				system = false;
				break;
			
			}
		}
		
	}
	
	private void salvar(Scanner scanner) {
		Funcionario funcionario = new Funcionario();
		System.out.println("Digite o NOME");
		String nome = scanner.next();
		System.out.println("Digite o cpf");
		String cpf = scanner.next();
		System.out.println("Digite o salario");
		BigDecimal salario = scanner.nextBigDecimal();
		
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		System.out.println("-----");
		System.out.println(funcionario);
		
		System.out.println("Digite o id da Unidade de trabalho");
		int idU = scanner.nextInt();
		
		System.out.println("Digite o id do cargo");
		int id = scanner.nextInt();
		UnidadeDeTrabalho unidadeDeTrabalho = utRepository.findById(idU).get();
		Cargo cargo2 = cargoRepository.findById(id).get();
		funcionario.getUnidadeTrabalhos().add(unidadeDeTrabalho);
		funcionario.setCargo(cargo2);
		funRepository.save(funcionario);
		System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Digite id");
		int id = scanner.nextInt();
		System.out.println("Digite a descrição");
		String descricao = scanner.next();
		
		Funcionario funcionario = new Funcionario();
	    funcionario.setId(id);
	    funcionario.setNome(descricao);
	    funRepository.save(funcionario);
	    System.out.println("Atualizado");
}
	
	private void visualizarSalioFuncionários() {
		List<FuncionarioProjecao> list= funRepository.findFuncionarioSalario();
		list.forEach(f -> {
			System.out.println("id: " + f.getId() + " | " + "Nome : " + f.getNome() + " | " + " salário: " + f.getSalario());
		});
	}

	private void visualizar(Scanner scanner) {
		System.out.println("Digite a página que deseja visualizar");
		Integer pag = scanner.nextInt();
		Pageable pageable = PageRequest.of(pag, 3, Sort.by(Sort.Direction.ASC, "nome"));
		Page<Funcionario> funcionarios = funRepository.findAll(pageable);
		
		System.out.println("Pagina atual => " + funcionarios.getNumber());
		System.out.println("Total elemento => " +funcionarios.getTotalElements());
		
		funcionarios.forEach(func -> System.out.println(func.getNome() + func.getCargo()));
	}


	private void deletar(Scanner scanner) {
		System.out.println("Digite id");
		int id = scanner.nextInt();
		funRepository.deleteById(id);
		System.out.println("Deletado");
	}




}













