package ru.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SortableDataTablesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public SortableDataTablesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public SortableDataTablesPage open() {
        driver.get("https://the-internet.herokuapp.com/tables");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table")));
        return this;
    }

    public String getCellByLastName(int table, String lastName, int column) {
        By cell = By.xpath(String.format(
                "(//table)[%d]//tbody//tr[td[1][normalize-space()='%s']]//td[%d]",
                table, lastName, column));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cell)).getText();
    }
}
