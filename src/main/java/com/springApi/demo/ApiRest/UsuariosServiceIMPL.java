package com.springApi.demo.ApiRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuariosServiceIMPL {
    @Autowired
    UsuariosRepo repo;

    public Flux<Usuarios> getAllUsuarios() {
        return repo.findAll();
    }

    public Mono<Usuarios> getUser(String id) {
        return repo.findById(id);
    }

    public Mono<Usuarios> saveUser(Usuarios usuario) {
        return repo.save(usuario);
    }

    public Mono<Usuarios> updateUser(Usuarios usuario) {
        return repo.save(usuario);
    }


    public Mono<Void> delUser(String id) {
        return repo.deleteById(id);
    }
}
