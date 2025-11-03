package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AbTestingPage;
import pages.HomePage;

public class AbTestingTest extends BaseTest {

    @Test
    public void headerShouldContainAbTest() {
        String text = new AbTestingPage(driver, wait).open().getHeaderText();
        Assert.assertTrue(text.contains("A/B Test"), "Header mismatch");
    }

    @Test
    public void headerViaHome() {
        new HomePage(driver, wait).open().clickLink("A/B Testing");
        String text = new AbTestingPage(driver, wait).getHeaderText();
        Assert.assertTrue(text.contains("A/B Test"));
    }
}
