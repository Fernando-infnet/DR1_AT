package com.example;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ViaCepTest {

    @BeforeAll
    static void setup() {
        baseURI = "https://viacep.com.br/ws";
    }

    // ===============================
    // 1. Teste de CEP com letras e CEPs inválidos (partição inválida)
    // ===============================
    @Test
    void cepComLetrasDeveRetornarErro() {
        given()
        .when()
            .get("/ABCDEF/json/") // CEP com letras (inválido)
        .then()
            .statusCode(anyOf(is(400), is(404)));
    }

    @Test
    void cepMuitoCurtoDeveRetornarErro() {
        given()
        .when()
            .get("/123/json/") // CEP curto (inválido)
        .then()
            .statusCode(anyOf(is(400), is(404)));
    }

    @Test
    void cepMuitoLongoDeveRetornarErro() {
        given()
        .when()
            .get("/123456789/json/") // CEP com 9 dígitos (inválido)
        .then()
            .statusCode(anyOf(is(400), is(404)));
    }

    // ===============================
    // 2. Consulta por endereço válido (classe válida)
    // ===============================
    @Test
    void consultaPorEnderecoValidoDeveRetornarLista() {
        given()
        .when()
            .get("/RS/Porto Alegre/Domingos/json/") // endereço existente
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }

    // ===============================
    // 3. Consulta por UF inválida (classe inválida)
    // ===============================
    @Test
    void ufInvalidaDeveRetornarErro() {
        given()
        .when()
            .get("/XX/Sao%20Paulo/Avenida%20Paulista/json/") // UF inválida
        .then()
            .statusCode(anyOf(is(400), is(404)));
    }

    @Test
    void ufComUmCaractereDeveRetornarErro() {
        given()
        .when()
            .get("/S/Sao%20Paulo/Avenida%20Paulista/json/") // UF com 1 letra
        .then()
            .statusCode(anyOf(is(400), is(404)));
    }

    @Test
    void ufComTresCaracteresDeveRetornarErro() {
        given()
        .when()
            .get("/ABC/Sao%20Paulo/Avenida%20Paulista/json/") // UF com 3 letras
        .then()
            .statusCode(anyOf(is(400), is(404)));
    }

    // ===============================
    // 4. Consulta de logradouro inexistente (classe inválida)
    // ===============================
    @Test
    void logradouroInexistenteDeveRetornarListaVazia() {
        given()
        .when()
            .get("/RS/Porto Alegre/Sabados/json/") // logradouro inexistente
        .then()
            .statusCode(200)
            .body("size()", equalTo(0));
    }

    @Test
    void logradouroVazioDeveRetornarErro() {
        given()
        .when()
            .get("/RS/Porto Alegre//json/") // logradouro vazio
        .then()
            .statusCode(anyOf(is(400), is(404)));
    }
}
