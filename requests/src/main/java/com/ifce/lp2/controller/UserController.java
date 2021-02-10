package com.ifce.lp2.controller;

import com.ifce.lp2.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String get() {
        return "Listar todos os usuários";
    }

    @PostMapping
    public String post(User user) {
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        return "Criar um novo usuário";
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
