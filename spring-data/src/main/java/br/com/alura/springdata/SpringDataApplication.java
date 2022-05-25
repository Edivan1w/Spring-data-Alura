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

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private final CrudCargoService cargoService;
	private final FuncionarioService funcionarioService;
	private boolean system = true;
	
	public SpringDataApplication(CrudCargoService repository, FuncionarioService funcionarioService) {
		this.cargoService = repository;
		this.funcionarioService = funcionarioService;
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
			
			int action = scan.nextInt();
			if(action == 1) {
				cargoService.inicial(scan);
			}
			else if(action == 2){
				funcionarioService.inicial(scan);
			}
			
			else {
				system = false;
			}
		}
		
		
	}

}
