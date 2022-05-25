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
			
			
			}
		}
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Digite a Empresa");
		String nome = scanner.next();
		
		UnidadeDeTrabalho unidadeDeTrabalho = new UnidadeDeTrabalho();
		unidadeDeTrabalho.setDescricao(nome);
		repository.save(unidadeDeTrabalho);
		System.out.println("Salvo");
	}
	
	
	
	
	
}
