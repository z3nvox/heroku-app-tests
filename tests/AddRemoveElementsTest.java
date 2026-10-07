package ru.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.herokuapp.base.TestBase;
import ru.herokuapp.pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends TestBase {
    @Test
    public void shouldAddTwoElementsAndDeleteOne() {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver).open();

        page.addElement();
        page.addElement();
        page.waitForDeleteButtons(2);
        Assert.assertEquals(page.getDeleteButtons().size(), 2);

        page.deleteElement();
        page.waitForDeleteButtons(1);
        Assert.assertEquals(page.getDeleteButtons().size(), 1);
    }
}
