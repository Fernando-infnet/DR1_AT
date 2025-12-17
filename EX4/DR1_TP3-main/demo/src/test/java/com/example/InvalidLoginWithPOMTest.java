package com.example;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.example.pages.RegisterPage;

public class InvalidLoginWithPOMTest extends BaseTest {

    @RegisterExtension
    ScreenshotOnFailure watcher = new ScreenshotOnFailure(driver);

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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement mensagemRegistro = wait.until(
                ExpectedConditions.visibilityOfElementLocated(register.successMessageLocator())
        );

        assertTrue(mensagemRegistro.getText().contains("Your registration completed"));

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
