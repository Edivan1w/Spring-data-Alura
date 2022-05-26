package br.com.alura.springdata.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.UnidadeDeTrabalho;
import br.com.alura.springdata.repository.UnidadeDeTrabalhoRepository;

@Service
public class UnidadeDeTrabalhoService {

	@Autowired
	private UnidadeDeTrabalhoRepository repository;
	private boolean system = true;
	
	public void inicial(Scanner scanner) {
		while(system) {
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
			default :{
				system = true;
				break;
			}
			}
		}
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Digite a Empresa");
		String nome = scanner.next();
		
		System.out.println("Digite o Estado da Empresa");
		System.out.println("Digite a cidade da Empresa");
		String estado = scanner.next();
		String cidade = scanner.next();
		
		UnidadeDeTrabalho unidadeDeTrabalho = new UnidadeDeTrabalho(nome, estado, cidade);
	
		repository.save(unidadeDeTrabalho);
		System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Digite o id da Empresa");
		int numero = scanner.nextInt();
		UnidadeDeTrabalho unidadeDeTrabalho = repository.findById(numero).get();
		
		unidadeDeTrabalho.setId(numero);
		
		System.out.println("Digite a descrição da Empresa");
		String descricao = scanner.next();
		unidadeDeTrabalho.setDescricao(descricao);
		
		System.out.println("Digite o Estado da Empresa");
		String estado = scanner.next();
		unidadeDeTrabalho.getEndereco().setCidade(estado);
		
		System.out.println("Digite a cidade da Empresa");
		String cidade = scanner.next();
		unidadeDeTrabalho.getEndereco().setCidade(cidade);
		
		repository.save(unidadeDeTrabalho);
		
		System.out.println("Atualizado");
		
		
	}
	
	private void visualizar() {
		repository.findAll().forEach(System.out::println);
	}
	
}
