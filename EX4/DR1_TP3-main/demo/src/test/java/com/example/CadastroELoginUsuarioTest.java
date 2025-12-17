package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CadastroELoginUsuarioTest extends BaseTest {

    @Test
    void cadastroELoginUsuario() {

        driver.get("https://demowebshop.tricentis.com");

        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Test");
        driver.findElement(By.id("LastName")).sendKeys("User");

        String email = "testeselenium" + System.currentTimeMillis() + "@example.com";
        driver.findElement(By.id("Email")).sendKeys(email);

        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");

        driver.findElement(By.id("register-button")).click();

        WebElement mensagemRegistro = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("result"))
        );
        assertTrue(mensagemRegistro.getText().contains("Your registration completed"));

        // Logout após registro
        driver.findElement(By.className("ico-logout")).click();

        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();

        // Verifica login bem-sucedido
        WebElement iconeLogout = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("ico-logout"))
        );
        assertTrue(iconeLogout.isDisplayed());
    }

}
