package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;
import pages.HomePage;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void addAndRemoveElements() {
        new HomePage(driver, wait).open().clickLink("Add/Remove Elements");
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver, wait);
        page.clickAdd(3);
        Assert.assertEquals(page.getDeleteButtonsCount(), 3);
        page.deleteAll();
        Assert.assertEquals(page.getDeleteButtonsCount(), 0);
    }
}
