package br.edu.ifce;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redirection")
public class RedirectionController {


    @GetMapping("moved")
    @ResponseStatus(code = HttpStatus.MOVED_PERMANENTLY)
    public String moved() {
        return "Moved";
    }

    @GetMapping("temp")
    @ResponseStatus(code = HttpStatus.MOVED_TEMPORARILY)
    public String temp() {
        return "Temp";
    }
}
