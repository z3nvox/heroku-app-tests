package ru.herokuapp.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.herokuapp.base.TestBase;
import ru.herokuapp.pages.CheckboxesPage;

import java.util.List;

public class CheckboxesTest extends TestBase {
    @Test
    public void shouldToggleBothCheckboxes() {
        List<WebElement> boxes = new CheckboxesPage(driver).open().getCheckboxes();
        Assert.assertEquals(boxes.size(), 2);
        Assert.assertFalse(boxes.get(0).isSelected());
        Assert.assertTrue(boxes.get(1).isSelected());

        boxes.get(0).click();
        Assert.assertTrue(boxes.get(0).isSelected());

        boxes.get(1).click();
        Assert.assertFalse(boxes.get(1).isSelected());
    }
}
