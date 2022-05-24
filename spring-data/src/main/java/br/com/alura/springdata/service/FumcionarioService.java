package br.com.alura.springdata.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.FuncionariRepository;

@Service
public class FumcionarioService {

	private final FuncionariRepository funRepository;
	private boolean system = true;
	
	public FumcionarioService(FuncionariRepository repository) {
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
	
	public void salvar(Scanner scanner) {
		System.out.println("Digite o cargo");
		String nome = scanner.next();
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		
		funRepository.save(funcionario);
		System.out.println("Salvo");
	}
	
	public void atualizar(Scanner scanner) {
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

	public void visualizar() {
		funRepository.findAll().forEach(System.out::println);;
	}


	public void deletar(Scanner scanner) {
		System.out.println("Digite id");
		int id = scanner.nextInt();
		funRepository.deleteById(id);
		System.out.println("Deletado");
	}




}













