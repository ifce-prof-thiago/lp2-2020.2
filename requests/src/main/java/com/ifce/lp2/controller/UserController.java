package com.ifce.lp2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String get() {
        return "Listar todos os usuários";
    }

    @PostMapping
    public String post() {
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
