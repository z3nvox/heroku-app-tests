package ru.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TyposPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By paragraph = By.tagName("p");

    public TyposPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public TyposPage open() {
        driver.get("https://the-internet.herokuapp.com/typos");
        wait.until(ExpectedConditions.presenceOfElementLocated(paragraph));
        return this;
    }

    public String getParagraphText() {
        return driver.findElement(paragraph).getText();
    }
}
