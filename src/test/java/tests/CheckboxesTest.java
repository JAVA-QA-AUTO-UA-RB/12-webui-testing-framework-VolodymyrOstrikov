package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckboxesTest extends BaseTest {
    @Test
    public void toggleCheckboxes() {
        CheckboxesPage page = new CheckboxesPage(driver, wait).open();
        page.toggleCheckbox(0);
        Assert.assertTrue(page.isChecked(0), "The first checkbox is not checked.");
        page.toggleCheckbox(1);
        Assert.assertFalse(page.isChecked(1), "The second checkbox is checked.");
    }
}