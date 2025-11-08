package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import pages.HomePage;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDrop() {
        new HomePage(driver, wait).open().clickLink("Drag and Drop");
        DragAndDropPage page = new DragAndDropPage(driver, wait);
        page.dragAtoB();
        Assert.assertEquals(page.getHeaderA(), "B"); // Після drag A стає B
    }
}