package com.ifce.lp2.controller;

import com.ifce.lp2.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    private static HashMap<String, User> repository = new HashMap<>();

    @GetMapping
    public Collection<User> get() {
        return repository.values();
    }

    @PostMapping
    public User post(@RequestBody User user) {
        user.setId(UUID.randomUUID().toString());

        repository.put(user.getId(), user);

        return user;
    }

    @PutMapping
    public String put() {
        return "Atualizar um usuário existente";
    }

    @DeleteMapping
    public String delete() {
        return "Deletar um usuário existente";
    }

}
