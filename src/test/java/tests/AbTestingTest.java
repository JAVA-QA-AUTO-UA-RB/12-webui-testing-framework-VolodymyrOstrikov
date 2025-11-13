package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AbTestingPage;
import pages.HomePage;

public class AbTestingTest extends BaseTest {
    @Test
    public void headerShouldContainAbTest() {
        AbTestingPage abPage = new AbTestingPage(driver, wait).open();
        Assert.assertTrue(abPage.getHeaderText().contains("A/B Test") || abPage.getHeaderText().contains("A/B Test Control"),
                "The title does not contain 'A/B Test' або 'A/B Test Control'");
    }

    @Test
    public void headerViaHome() {
        HomePage homePage = new HomePage(driver, wait).open();
        homePage.goToAbTesting();
        AbTestingPage abPage = new AbTestingPage(driver, wait);
        Assert.assertTrue(abPage.getHeaderText().contains("A/B Test") || abPage.getHeaderText().contains("A/B Test Control"),
                "The title does not contain 'A/B Test' або 'A/B Test Control'");
    }
}