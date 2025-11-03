package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HorizontalSliderPage;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void moveSlider() {
        new HomePage(driver, wait).open().clickLink("Horizontal Slider");
        HorizontalSliderPage page = new HorizontalSliderPage(driver, wait);
        page.moveSliderTo("4");
        Assert.assertEquals(page.getValue(), "4");
    }
}
