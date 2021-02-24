package br.edu.ifce;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("success")
public class SuccessController {


    @GetMapping
    public String get() {
        return "OK";
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String post() {
        return "Created";
    }

    @GetMapping("async")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public String accepted() {
        return "Accepted";
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public String delete() {
        return "Deleted";
    }

}
