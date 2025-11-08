package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    public DragAndDropPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public DragAndDropPage open() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        return this;
    }

    public void dragAtoB() {
        wait.until(ExpectedConditions.visibilityOf(columnA));
        new Actions(driver).dragAndDrop(columnA, columnB).perform();
    }

    public String getHeaderA() {
        wait.until(ExpectedConditions.visibilityOf(columnA));
        return columnA.getText();
    }
}