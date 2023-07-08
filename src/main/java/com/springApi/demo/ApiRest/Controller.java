package com.springApi.demo.ApiRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    PersonajesServiceIMPL psimpl;

    @GetMapping("/allCharacters")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Personajes> allCharacters() {
        return psimpl.allCharacters();
    }

    @GetMapping("/hola2")
    public String hola() {
        return "hola";
    }

    @GetMapping("/findCharacters/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Personajes> findCharacters(@PathVariable String id) {
        return psimpl.findCharacters(id);
    }

    @PostMapping("/addCharacters")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Personajes> addCharacters(@RequestBody Personajes personajes) {
        return psimpl.addCharacters(personajes);
    }

    @PutMapping("/updateCharacters")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Personajes> updateCharacters(@RequestBody Personajes personajes) {
        return psimpl.updateCharacters(personajes);
    }

    @DeleteMapping("/deleteCharacters/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteCharacters(@PathVariable String id) {
        return psimpl.deleteCharacters(id);
    }

    @DeleteMapping("/deleteAllCharacters")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteAllCharacters() {
        return psimpl.deleteAllCharacters();
    }
}
