package com.springApi.demo.ApiRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonajesServiceIMPL {

    //Instanciamos la clase que contiene la implementacion de los repositorios contra la BDD.
    @Autowired
    PersonajesRepo repo;

    //CRUD DE LOS PERSONAJES
    public Flux<Personajes> allCharacters() {
        //Flux es como una lista en el cual se envian varios datos.
        return repo.findAll();
    }

    public Mono<Personajes> addCharacters(Personajes personajes) {
        //El Mono es solo de un proceso por ello se usa aqui para añadir el personaje.
        return repo.save(personajes);
    }

    public Mono<Personajes> updateCharacters(Personajes personajes) {
        return repo.save(personajes);
    }

    public Mono<Personajes> findCharacters(String id) {
        return repo.findById(id);
    }

    public Mono<Void> deleteCharacters(String id) {
        return repo.deleteById(id);
    }

    public Mono<Void> deleteAllCharacters() {
        return repo.deleteAll();
    }


}
