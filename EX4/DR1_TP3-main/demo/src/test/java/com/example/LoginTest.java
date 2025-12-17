package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test
    public void Login_Sem_Sucesso() {
        driver.get("https://automationexercise.com/login");

        driver.findElement(By.name("email")).sendKeys("emailerrado@test.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String urlAtual = driver.getCurrentUrl();
        Assertions.assertFalse(urlAtual.contains("account"), "Login não foi realizado!");
    }
}
