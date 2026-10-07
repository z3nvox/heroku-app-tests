package ru.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropdownPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public DropdownPage open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        wait.until(ExpectedConditions.presenceOfElementLocated(dropdown));
        return this;
    }

    public Select getDropdown() {
        return new Select(driver.findElement(dropdown));
    }
}
