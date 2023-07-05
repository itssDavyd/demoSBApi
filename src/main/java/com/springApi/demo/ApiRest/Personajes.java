package com.springApi.demo.ApiRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//Con la ayuda de la dependencia Lombok con tan solo indicarle por anotacion ya no tendriamos que hacer las generaciones de setters and getter ni los constructores
// ya que los estamos indicando con las propias anotaciones.
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("Characters") //Indicamos nombre de la tabla.
public class Personajes {

    @Id
    private String id;
    private String name;
    private String surname;
    private String age;
    private char sex;
    private String[] games;
    private String data;


}
