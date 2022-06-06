package br.com.alura.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.FuncionariRepository;
@Service
public class RelatoriosService {

	private final FuncionariRepository funcionariRepository;
	
	private boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatoriosService(FuncionariRepository funcionariRepository) {
		this.funcionariRepository = funcionariRepository;
	}
	

	public void inicial(Scanner scanner) {
		
		while(system) {
			System.out.println("0 = sair");
			System.out.println("1 = buscar funcionário");
			System.out.println("1 = buscar por parametros");
			System.out.println("1 = buscar por data maior");
			
			int action = scanner.nextInt();
			switch(action) {
			
			case 1:
				buscarPorNome(scanner);
			    break;
				
			case 2:
				buscarPorPametros(scanner);
				break;
				
			case 3:
				buscarPorDataMaior(scanner);
				break;
				
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
	
	private void buscarPorPametros(Scanner scanner) {
		System.out.println("Digite o nome do funcionario que deseja procurar");
		String nome = scanner.next();
		System.out.println("Digite o salario do funcionario que deseja procurar");
		Double salario = scanner.nextDouble();
		System.out.println("Digite a data de cadastro do funcionario que deseja procurar");
		String data = scanner.next();
		LocalDate date = LocalDate.parse(data, formatter);
		
		List<Funcionario> list = funcionariRepository.findNomeSalarioMaiorDataContratacao(nome, salario, date);
		list.forEach(System.out::println);
		
	}
	
	private void buscarPorDataMaior(Scanner scanner) {
		String data = scanner.next();
		LocalDate date = LocalDate.parse(data, formatter);
		
		List<Funcionario> list = funcionariRepository.buscarPorDataMaior(date);
		list.forEach(System.out::println);
	}
}













