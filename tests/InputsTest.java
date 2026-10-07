package ru.herokuapp.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.herokuapp.base.TestBase;
import ru.herokuapp.pages.InputsPage;

public class InputsTest extends TestBase {
    @Test
    public void shouldAcceptNumericInputAndArrowKeys() {
        WebElement input = new InputsPage(driver).open().getInput();
        input.sendKeys("123");
        Assert.assertEquals(input.getAttribute("value"), "123");

        input.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(input.getAttribute("value"), "124");

        input.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(input.getAttribute("value"), "123");
    }

    @Test
    public void shouldRejectNonNumericValueForNumberInput() {
        WebElement input = new InputsPage(driver).open().getInput();
        input.sendKeys("abc");
        Assert.assertEquals(input.getAttribute("value"), "");
    }
}
