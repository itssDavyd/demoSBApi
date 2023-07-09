package com.springApi.demo.ApiRest;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UsuariosRepo extends ReactiveMongoRepository<Usuarios, String> {
}
