package com.springApi.demo.ApiRest;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonajesRepo extends ReactiveMongoRepository<Personajes, String> {
}
