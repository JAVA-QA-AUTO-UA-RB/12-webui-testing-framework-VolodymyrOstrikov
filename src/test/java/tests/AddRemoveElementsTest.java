package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends BaseTest {
    @Test
    public void addAndRemoveElements() {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver, wait).open();

        page.clickAdd();
        page.clickAdd();
        page.clickAdd();

        Assert.assertEquals(page.getDeleteButtonsCount(), 3,
                "The number of delete buttons does not match");

        page.deleteAll();

        Assert.assertEquals(page.getDeleteButtonsCount(), 0,
                "Items not deleted");
    }
}
