package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddRemoveElementsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "button[onclick='addElement()']")
    private WebElement addButton;

    @FindBy(css = "#elements button")
    private List<WebElement> deleteButtons;

    public AddRemoveElementsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public AddRemoveElementsPage open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        return this;
    }

    public void clickAdd(int times) {
        for (int i = 0; i < times; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
        }
    }

    public int getDeleteButtonsCount() {
        return deleteButtons.size();
    }

    public void deleteAll() {
        deleteButtons.forEach(el -> wait.until(ExpectedConditions.elementToBeClickable(el)).click());
    }

}