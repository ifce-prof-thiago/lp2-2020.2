package br.edu.ifce.lp2.repository;

import br.edu.ifce.lp2.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
}
