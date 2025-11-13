package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class DragAndDropTest extends BaseTest {
    @Test
    public void dragAndDrop() {
        DragAndDropPage page = new DragAndDropPage(driver, wait).open();
        String initialHeaderA = page.getHeaderA();
        page.dragAtoB();
        Assert.assertNotEquals(page.getHeaderA(), initialHeaderA, "Drag and drop did not happen");
    }
}