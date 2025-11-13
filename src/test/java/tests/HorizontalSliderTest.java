package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class HorizontalSliderTest extends BaseTest {
    @Test
    public void moveSlider() {
        HorizontalSliderPage page = new HorizontalSliderPage(driver, wait).open();
        page.moveSliderTo("3.5");
        Assert.assertEquals(page.getValue(), "3.5", "The slider value does not match.");
    }
}