package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InvalidLoginTest extends BaseTest {

    @Test
    void tentativasLoginInvalidas() {

        driver.get("https://demowebshop.tricentis.com");

        // ===============================
        // Tentativa 1: Email inválido
        // ===============================
        driver.findElement(By.id("Email")).sendKeys("invalidoEmail@mail.com");
        driver.findElement(By.id("Password")).sendKeys("valido_senha");
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();

        WebElement erroEmail = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-error"))
        );
        assertTrue(erroEmail.getText().contains("Login was unsuccessful"));

        // ===============================
        // Tentativa 2: Senha inválida
        // ===============================
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Password")).clear();

        driver.findElement(By.id("Email")).sendKeys("emailCorreto@mail.com");
        driver.findElement(By.id("Password")).sendKeys("invalido_senha");
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();

        WebElement erroSenha = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-error"))
        );
        assertTrue(erroSenha.getText().contains("Login was unsuccessful"));

        // ===============================
        // Tentativa 3: Ambos inválidos
        // ===============================
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Password")).clear();

        driver.findElement(By.id("Email")).sendKeys("invalidoEmail@mail.com\"");
        driver.findElement(By.id("Password")).sendKeys("senha_errada");
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();

        WebElement erroAmbos = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-error"))
        );
        assertTrue(erroAmbos.getText().contains("Login was unsuccessful"));
    }
}
