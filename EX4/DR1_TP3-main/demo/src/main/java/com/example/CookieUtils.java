package com.example;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.*;

public class CookieUtils {

    private static final String COOKIE_FILE = "cookies.data";

    public static void saveCookies(WebDriver driver) throws IOException {
        File file = new File(COOKIE_FILE);
        file.delete();
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        for (Cookie ck : driver.manage().getCookies()) {
            writer.write(
                ck.getName() + ";" +
                ck.getValue() + ";" +
                ck.getDomain() + ";" +
                ck.getPath() + ";" +
                ck.getExpiry() + ";" +
                ck.isSecure());
            writer.newLine();
        }
        writer.close();
    }

    public static void loadCookies(WebDriver driver) throws IOException {
        File file = new File(COOKIE_FILE);
        if (!file.exists()) return;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            Cookie cookie = new Cookie
                    .Builder(parts[0], parts[1])
                    .domain(parts[2])
                    .path(parts[3])
                    .build();
            driver.manage().addCookie(cookie);
        }
        reader.close();
    }
}
