package br.com.alura.springdata.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;



import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.FuncionariRepository;
import br.com.alura.springdata.specification.SpecificationFuncionario;
@Service
public class RelatorioDinamicoFuncionario {
	
	private final FuncionariRepository funcionariRepository;
	private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatorioDinamicoFuncionario(FuncionariRepository funcionariRepository) {
		this.funcionariRepository = funcionariRepository;
	}

	public void consultaDinamica(Scanner scanner) {
		System.out.println("Digite o nome ou parte do nome que deseja consultar");
		String nome = scanner.next();
		if(nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}
		
		System.out.println("Digite o cpf que deseja consultar");
		String cpf = scanner.next();
		if(cpf.equalsIgnoreCase("NULL")) {
			cpf = null;
		}
		
		System.out.println("Digite o salario que deseja consultar");
		BigDecimal salario = scanner.nextBigDecimal();
		if(salario.doubleValue() == 0) {
			salario = null;
		}
		
		System.out.println("Digite a data que deseja consultar");
		String data = scanner.next();
		LocalDate dataContratação;
		if(data.equalsIgnoreCase("NULL")) {
			dataContratação = null;
		}else {
			dataContratação = LocalDate.parse(data, dateFormatter);
		}
		
		List<Funcionario> funcionarios = funcionariRepository.findAll(Specification
				.where(SpecificationFuncionario.nome(nome))
				.or(SpecificationFuncionario.cpf(cpf))
				.or(SpecificationFuncionario.salario(salario))
				.or(SpecificationFuncionario.dataContratação(dataContratação)));
		funcionarios.forEach(System.out::println);
	}

}
