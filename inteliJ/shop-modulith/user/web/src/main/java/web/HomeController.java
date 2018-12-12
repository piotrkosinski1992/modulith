package web;

import api.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface HomeController {
    @PostMapping("/register")
    ResponseEntity register(@RequestBody @Valid CustomerDTO customerDTO);

}
