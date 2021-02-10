package com.ifce.lp2.controller;

import com.ifce.lp2.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    private static HashMap<String, User> repository = new HashMap<>();

    @GetMapping
    public String get() {
        return "Listar todos os usuários";
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
