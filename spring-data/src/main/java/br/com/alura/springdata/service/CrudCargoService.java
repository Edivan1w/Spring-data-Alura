package br.com.alura.springdata.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.repository.CargoRepository;
@Service
public class CrudCargoService {
	private final CargoRepository cargoRepository;
	private boolean system = true;

	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while (system) {
			
			System.out.println("0 = sair");
			System.out.println("1 = salvar");
			System.out.println("2 = atualizar");
			System.out.println("3 = visualizar");
			System.out.println("4 = deletar");
			
			int action = scanner.nextInt();
			switch (action) {
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
			case 4: {
				deletarPorId(scanner);
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
		Cargo cargo = new Cargo();
		cargo.setNome(nome);
		cargoRepository.save(cargo);
		System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("id");
		int id = scanner.nextInt();
		System.out.println("Descrição do cargo");
		String nome = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setNome(nome);
	    cargoRepository.save(cargo);
	    System.out.println("Atualizado");
	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(System.out::println);
	}
	
	private void deletarPorId(Scanner scanner) {
		System.out.println("ID");
		int id = scanner.nextInt();
		
		cargoRepository.deleteById(id);
		System.out.println("Deletado");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
