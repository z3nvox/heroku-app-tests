package ru.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HoversPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By profiles = By.cssSelector(".figure");
    private final By caption = By.cssSelector(".figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public HoversPage open() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        wait.until(ExpectedConditions.presenceOfElementLocated(profiles));
        return this;
    }

    public List<WebElement> getProfiles() {
        return driver.findElements(profiles);
    }

    public void hover(WebElement profile) {
        new Actions(driver).moveToElement(profile).perform();
        wait.until(ExpectedConditions.visibilityOf(profile.findElement(caption)));
    }

    public String getCaption(WebElement profile) {
        return profile.findElement(caption).getText();
    }

    public void clickProfileLink(WebElement profile) {
        profile.findElement(By.tagName("a")).click();
    }
}
