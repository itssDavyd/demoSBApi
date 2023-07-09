package com.springApi.demo.Utils;

import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@UtilityClass
public class PasswordHashUtils {

    //Funcion para encriptar las contraseñas.
    public static String PasswordHash(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    //Funcion para controlar el verificado de las contraseñas hasheadas por seguridad en la bdd.
    public static boolean CheckPassowrd(String password, String hash) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, hash);
    }
}
