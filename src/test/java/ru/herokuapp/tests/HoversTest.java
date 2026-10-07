package ru.herokuapp.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.herokuapp.base.TestBase;
import ru.herokuapp.pages.HoversPage;

import java.util.List;

public class HoversTest extends TestBase {
    @Test
    public void shouldHoverOverEveryProfileAndOpenItsPage() {
        HoversPage page = new HoversPage(driver).open();
        List<WebElement> profiles = page.getProfiles();
        Assert.assertEquals(profiles.size(), 3);

        for (int i = 0; i < profiles.size(); i++) {
            page.hover(profiles.get(i));
            String caption = page.getCaption(profiles.get(i));
            Assert.assertTrue(caption.contains("name: user" + (i + 1)), caption);

            page.clickProfileLink(profiles.get(i));
            Assert.assertFalse(driver.getTitle().contains("404"), "Profile returned 404");
            Assert.assertFalse(driver.getPageSource().contains("404 Not Found"), "Profile returned 404");
            driver.navigate().back();
            page = new HoversPage(driver).open();
            profiles = page.getProfiles();
        }
    }
}
