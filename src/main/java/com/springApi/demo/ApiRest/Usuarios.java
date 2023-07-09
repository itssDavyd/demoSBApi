package com.springApi.demo.ApiRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("Usuarios")
public class Usuarios {
    @Id
    private String id;
    private String name;
    private String surname;
    private String role;
    private String password;
    private String email;
}
