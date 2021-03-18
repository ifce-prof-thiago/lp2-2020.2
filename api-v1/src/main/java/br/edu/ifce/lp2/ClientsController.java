package br.edu.ifce.lp2;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("clients")
@RestController
public class ClientsController {

    private static Map<String, Client> clientDB = new HashMap<>();

    @PostMapping
    @ResponseStatus(CREATED)
    public void post(@RequestBody Client request) {
        var id = UUID.randomUUID().toString();
        request.setId(id);
        request.setEnabled(false);

        for (var client : clientDB.values()) {
            if (client.getEmail().equals(request.getEmail())) {
                throw new RuntimeException("Já existe um usuário com o mesmo email");
            }
        }

        System.out.println("Email de confirmação enviado para  " + request.getEmail());

        clientDB.put(id, request);
    }

    @GetMapping
    public Map<String, Client> get() {
        return clientDB;
    }

}
