package ru.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By input = By.tagName("input");

    public InputsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public InputsPage open() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        wait.until(ExpectedConditions.presenceOfElementLocated(input));
        return this;
    }

    public WebElement getInput() {
        return driver.findElement(input);
    }
}
