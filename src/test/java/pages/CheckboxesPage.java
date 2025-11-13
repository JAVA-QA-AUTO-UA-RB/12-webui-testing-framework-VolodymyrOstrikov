package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckboxesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#checkboxes input")
    private List<WebElement> checkboxes;

    public CheckboxesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = (wait != null) ? wait : new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public CheckboxesPage open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        wait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/checkboxes"));
        wait.until(ExpectedConditions.visibilityOfAllElements(checkboxes));
        return this;
    }

    public void toggleCheckbox(int index) {
        WebElement cb = checkboxes.get(index);
        wait.until(ExpectedConditions.elementToBeClickable(cb)).click();
    }

    public boolean isChecked(int index) {
        return checkboxes.get(index).isSelected();
    }
}
