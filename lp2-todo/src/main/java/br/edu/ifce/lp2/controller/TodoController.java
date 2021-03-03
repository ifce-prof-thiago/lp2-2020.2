package br.edu.ifce.lp2.controller;

import br.edu.ifce.lp2.model.Todo;
import br.edu.ifce.lp2.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody Todo todo) {
        repository.save(todo);
    }

}
