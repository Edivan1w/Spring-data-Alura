package br.com.alura.springdata.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.FuncionariRepository;
@Service
public class RelatoriosService {

	private final FuncionariRepository funcionariRepository;
	
	private boolean system = true;
	
	public RelatoriosService(FuncionariRepository funcionariRepository) {
		this.funcionariRepository = funcionariRepository;
	}
	

	public void inicial(Scanner scanner) {
		
		while(system) {
			System.out.println("0 = sair");
			System.out.println("1 = buscar funcionário");
			
			
			int action = scanner.nextInt();
			switch(action) {
			
			case 1:
				buscarPorNome(scanner);
			
			default:
				system = false;
				break;
			
			}
			
		}
	}
	
	private void buscarPorNome(Scanner scanner){
		System.out.println("Digite o no do funcionario que deseja procurar");
		String nome = scanner.next();
		List<Funcionario> list = funcionariRepository.findByNome(nome);
		list.forEach(System.out::println);
	}
	
}













