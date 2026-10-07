package ru.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddRemoveElementsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By addButton = By.xpath("//button[text()='Add Element']");
    private final By deleteButton = By.xpath("//button[text()='Delete']");

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public AddRemoveElementsPage open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        return this;
    }

    public void addElement() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void deleteElement() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }

    public void waitForDeleteButtons(int expectedCount) {
        wait.until(driver -> driver.findElements(deleteButton).size() == expectedCount);
    }

    public List<WebElement> getDeleteButtons() {
        return driver.findElements(deleteButton);
    }
}
