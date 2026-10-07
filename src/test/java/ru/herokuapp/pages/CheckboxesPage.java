package ru.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckboxesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By checkboxes = By.cssSelector("[type=checkbox]");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public CheckboxesPage open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        wait.until(ExpectedConditions.presenceOfElementLocated(checkboxes));
        return this;
    }

    public List<WebElement> getCheckboxes() {
        return driver.findElements(checkboxes);
    }
}
