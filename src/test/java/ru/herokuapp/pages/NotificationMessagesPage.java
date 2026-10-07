package ru.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationMessagesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By clickHere = By.linkText("Click here");
    private final By flash = By.id("flash");

    public NotificationMessagesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public NotificationMessagesPage open() {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        wait.until(ExpectedConditions.elementToBeClickable(clickHere));
        return this;
    }

    public void clickAction() {
        wait.until(ExpectedConditions.elementToBeClickable(clickHere)).click();
    }

    public String getNotificationText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(flash)).getText();
    }
}
