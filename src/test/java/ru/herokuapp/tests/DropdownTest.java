package ru.herokuapp.tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.herokuapp.base.TestBase;
import ru.herokuapp.pages.DropdownPage;

public class DropdownTest extends TestBase {
    @Test
    public void shouldSelectBothOptions() {
        Select dropdown = new DropdownPage(driver).open().getDropdown();
        Assert.assertEquals(dropdown.getOptions().size(), 3);
        Assert.assertEquals(dropdown.getOptions().get(1).getText(), "Option 1");
        Assert.assertEquals(dropdown.getOptions().get(2).getText(), "Option 2");

        dropdown.selectByVisibleText("Option 1");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1");

        dropdown.selectByVisibleText("Option 2");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");
    }
}
