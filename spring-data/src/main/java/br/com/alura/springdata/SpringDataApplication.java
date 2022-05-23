package br.com.alura.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.repository.CargoRepository;
import br.com.alura.springdata.service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private final CrudCargoService cargoService;
	
	private boolean system = true;
	
	public SpringDataApplication(CrudCargoService repository) {
		this.cargoService = repository;
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
			
			int action = scan.nextInt();
			if(action == 1) {
				cargoService.inicial(scan);
			}else {
				system = false;
			}
		}
		
		
	}

}
