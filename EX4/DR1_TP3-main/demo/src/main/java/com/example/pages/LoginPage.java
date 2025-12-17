package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By email = By.id("Email");
    private By password = By.id("Password");
    private By loginButton = By.cssSelector("input.button-1.login-button");
    private By errorMessage = By.cssSelector(".message-error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherLogin(String emailStr, String pass) {
        driver.findElement(email).clear();
        driver.findElement(password).clear();
        driver.findElement(email).sendKeys(emailStr);
        driver.findElement(password).sendKeys(pass);
    }

    public void clicarLogin() {
        driver.findElement(loginButton).click();
    }

    public String obterMensagemErro() {
        return driver.findElement(errorMessage).getText();
    }
}
