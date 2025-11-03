package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.HomePage;

public class DropdownTest extends BaseTest {

    @Test
    public void selectOption() {
        new HomePage(driver, wait).open().clickLink("Dropdown");
        DropdownPage page = new DropdownPage(driver, wait);
        page.selectByValue("1");
        Assert.assertEquals(page.getSelectedText(), "Option 1");
    }
}
