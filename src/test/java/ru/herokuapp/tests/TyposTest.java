package ru.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.herokuapp.base.TestBase;
import ru.herokuapp.pages.TyposPage;

public class TyposTest extends TestBase {
    @Test
    public void shouldContainExpectedParagraphText() {
        String text = new TyposPage(driver).open().getParagraphText();

        // The page intentionally introduces a random typo on page load,
        // so the test checks the stable part of the paragraph.
        Assert.assertTrue(
                text.contains("This example demonstrates a typo"),
                "Unexpected paragraph text: " + text
        );
    }
}
