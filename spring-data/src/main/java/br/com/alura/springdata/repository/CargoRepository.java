package br.com.alura.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springdata.orm.Cargo;

//é uma anotação que o spring vai ler.
@Repository                                            //o Integer é o tipo da primary key
public interface CargoRepository extends CrudRepository<Cargo, Integer> {

}
