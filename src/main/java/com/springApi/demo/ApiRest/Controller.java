package com.springApi.demo.ApiRest;

import com.springApi.demo.Utils.PasswordHashUtils;
import lombok.experimental.UtilityClass;
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

    @Autowired
    UsuariosServiceIMPL userimpl;

    //PETICIONES PARA CONTROLAR LA TABLA USUARIOS.

    @GetMapping("/getAllUsuarios")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Usuarios> getAllUsuarios() {
        return userimpl.getAllUsuarios();
    }

    @GetMapping("/getUsuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Usuarios> getUsuario(@PathVariable String id) {
        return userimpl.getUser(id);
    }

    @PostMapping("/saveUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Usuarios> saveUsuario(@RequestBody Usuarios usuarios) {
        //Hasheamos la contraseña usando nuestro utils.
        String passSinModificar = usuarios.getPassword();
        usuarios.setPassword(PasswordHashUtils.PasswordHash(passSinModificar));
        return userimpl.saveUser(usuarios);
    }

    @PutMapping("/updateUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Usuarios> updateUsuario(@RequestBody Usuarios usuarios) {
        return userimpl.updateUser(usuarios);
    }

    @DeleteMapping("/delUsuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> delUsuario(@PathVariable String id) {
        return userimpl.delUser(id);
    }

    //PETICIONES PARA CONTROLAR LA TABLA PERSONAJES.

    @GetMapping("/allCharacters")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Personajes> allCharacters() {
        return psimpl.allCharacters();
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
