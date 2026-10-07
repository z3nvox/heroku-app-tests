package ru.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.herokuapp.base.TestBase;
import ru.herokuapp.pages.SortableDataTablesPage;

public class SortableDataTablesTest extends TestBase {
    @Test
    public void shouldVerifySeveralTableCells() {
        SortableDataTablesPage page = new SortableDataTablesPage(driver).open();

        Assert.assertEquals(page.getCellByLastName(1, "Smith", 2), "John");
        Assert.assertEquals(page.getCellByLastName(1, "Smith", 3), "jsmith@gmail.com");
        Assert.assertEquals(page.getCellByLastName(1, "Bach", 2), "Frank");
        Assert.assertEquals(page.getCellByLastName(1, "Doe", 2), "Jason");
        Assert.assertEquals(page.getCellByLastName(1, "Conway", 2), "Tim");
    }
}
