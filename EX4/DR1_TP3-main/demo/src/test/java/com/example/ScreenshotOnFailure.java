package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotOnFailure implements TestWatcher {

    private WebDriver driver;

    public ScreenshotOnFailure(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if (driver == null) return;

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String testName = context.getDisplayName().replaceAll("[^a-zA-Z0-9]", "_");
        File destination = new File("screenshots/" + testName + ".png");
        destination.getParentFile().mkdirs();

        try {
            Files.copy(screenshot.toPath(), destination.toPath());
            System.out.println("Screenshot salvo em: " + destination.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {}

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {}

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {}
}