package br.com.alura.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.repository.CargoRepository;
import br.com.alura.springdata.repository.FuncionariRepository;
import br.com.alura.springdata.service.CrudCargoService;
import br.com.alura.springdata.service.FuncionarioService;
import br.com.alura.springdata.service.UnidadeDeTrabalhoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private final CrudCargoService cargoService;
	private final FuncionarioService funcionarioService;
	private final UnidadeDeTrabalhoService deTrabalhoService;
	private boolean system = true;
	
	public SpringDataApplication(CrudCargoService repository, FuncionarioService funcionarioService, UnidadeDeTrabalhoService deTrabalhoService) {
		this.cargoService = repository;
		this.funcionarioService = funcionarioService;
		this.deTrabalhoService = deTrabalhoService;
	}

	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual ação você quer exercer?");
			System.out.println("0 - sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionário");
			System.out.println("3 - Unidade de trabalho");
			
			int action = scan.nextInt();
			if(action == 1) {
				cargoService.inicial(scan);
			}
			else if(action == 2){
				funcionarioService.inicial(scan);
			}
			else if(action == 3){
				deTrabalhoService.inicial(scan);
			}
			
			else {
				system = false;
			}
		}
		
		
	}

}
