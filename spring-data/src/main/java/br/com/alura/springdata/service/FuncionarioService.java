package br.com.alura.springdata.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.FuncionariRepository;

@Service
public class FuncionarioService {

	@Autowired
	private final FuncionariRepository funRepository;
	private boolean system = true;
	
	public FuncionarioService(FuncionariRepository repository) {
		this.funRepository = repository;
	}
	
	public void inicial(Scanner scanner) {
		
		while (system) {
			System.out.println("0 = sair");
			System.out.println("1 = salvar");
			System.out.println("2 = atualizar");
			System.out.println("3 = visualizar");
			System.out.println("4 = deletar");
			
			int action = scanner.nextInt();
			switch(action) {
			
			case 1: {
				salvar(scanner);
				break;
			}
			case 2: {
				atualizar(scanner);
				break;
			}
			case 3: {
				visualizar();
				break;
			}
			case 4:  {
				deletar(scanner);
				break;
			}
			default:
				system = false;
				break;
			
			}
		}
		
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Digite o cargo");
		String nome = scanner.next();
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		
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

	private void visualizar() {
		Iterable<Funcionario> funcionario = funRepository.findAll();
		funcionario.forEach(System.out::println);
	}


	private void deletar(Scanner scanner) {
		System.out.println("Digite id");
		int id = scanner.nextInt();
		funRepository.deleteById(id);
		System.out.println("Deletado");
	}




}













