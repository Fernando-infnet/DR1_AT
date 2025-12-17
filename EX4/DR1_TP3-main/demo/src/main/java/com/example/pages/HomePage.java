package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By loginLink = By.className("ico-login");
    private By registerLink = By.className("ico-register");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrir() {
        driver.get("https://demowebshop.tricentis.com");
    }

    public void clicarLogin() {
        driver.findElement(loginLink).click();
    }

    public void clicarRegister() {
        driver.findElement(registerLink).click();
    }
}
