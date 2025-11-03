package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;
import pages.HomePage;

public class CheckboxesTest extends BaseTest {

    @Test
    public void toggleCheckboxes() {
        new HomePage(driver, wait).open().clickLink("Checkboxes");
        CheckboxesPage page = new CheckboxesPage(driver, wait);
        page.toggleCheckbox(0);
        Assert.assertTrue(page.isChecked(0));
        page.toggleCheckbox(1);
        Assert.assertFalse(page.isChecked(1));
    }
}