package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AddRemoveElementsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By addButton = By.xpath("//button[text()='Add Element']");
    private final By deleteButtons = By.xpath("//button[text()='Delete']");

    public AddRemoveElementsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = (wait != null) ? wait : new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public AddRemoveElementsPage open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        return this;
    }

    public void clickAdd() {
        driver.findElement(addButton).click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(deleteButtons, 0));
    }

    public void deleteAll() {
        List<WebElement> buttons = driver.findElements(deleteButtons);
        while (!buttons.isEmpty()) {
            buttons.get(0).click();
            buttons = driver.findElements(deleteButtons);
        }
    }

    public int getDeleteButtonsCount() {
        return driver.findElements(deleteButtons).size();
    }
}
