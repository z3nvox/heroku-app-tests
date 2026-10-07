package ru.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.herokuapp.base.TestBase;
import ru.herokuapp.pages.NotificationMessagesPage;

public class NotificationMessagesTest extends TestBase {
    @Test
    public void shouldDisplayNotificationAfterClick() {
        NotificationMessagesPage page = new NotificationMessagesPage(driver).open();
        page.clickAction();

        String notification = page.getNotificationText();
        Assert.assertTrue(notification.contains("Action successful")
                        || notification.contains("Action unsuccesful"),
                "Unexpected notification: " + notification);
    }
}
