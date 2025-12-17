package com.example;

import com.example.pages.HomePage;
import com.example.pages.RegisterPage;
import com.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvalidLoginWithPOMTest extends BaseTest {

    @Test
    void cadastroETentativasLoginInvalidas() {

        HomePage home = new HomePage(driver);
        RegisterPage register = new RegisterPage(driver);
        LoginPage login = new LoginPage(driver);

        // ===============================
        // CADASTRO DE USUÁRIO VÁLIDO
        // ===============================
        home.abrir();
        home.clicarRegister();

        String emailValido = "user" + System.currentTimeMillis() + "@mail.com";
        String senhaValida = "senhaValida123";

        register.preencherFormulario("Test", "User", emailValido, senhaValida);
        register.clicarRegister();

        WebElement mensagemRegistro = wait.until(
                ExpectedConditions.visibilityOf(register.obterMensagemSucesso())
        );
        assertTrue(register.obterMensagemSucesso().contains("Your registration completed"));

        driver.findElement(By.className("ico-logout")).click();

        // ===============================
        // TENTATIVAS DE LOGIN INVÁLIDAS
        // ===============================
        home.clicarLogin();

        // Tentativa 1: Email inválido
        login.preencherLogin("invalidoEmail@mail.com", senhaValida);
        login.clicarLogin();
        WebElement erroEmail = wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".message-error")))
        );
        assertTrue(login.obterMensagemErro().contains("Login was unsuccessful"));

        // Tentativa 2: Senha inválida
        login.preencherLogin(emailValido, "senhaErrada");
        login.clicarLogin();
        WebElement erroSenha = wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".message-error")))
        );
        assertTrue(login.obterMensagemErro().contains("Login was unsuccessful"));

        // Tentativa 3: Ambos inválidos
        login.preencherLogin("emailInexistente@mail.com", "senhaErrada");
        login.clicarLogin();
        WebElement erroAmbos = wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".message-error")))
        );
        assertTrue(login.obterMensagemErro().contains("Login was unsuccessful"));
    }
}
