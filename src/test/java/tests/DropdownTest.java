package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class DropdownTest extends BaseTest {
    @Test
    public void selectOption() {
        DropdownPage page = new DropdownPage(driver, wait).open();
        page.selectByValue("1");
        Assert.assertEquals(page.getSelectedText(), "Option 1", "The correct option was not selected.");
    }
}