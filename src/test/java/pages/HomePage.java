package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "ul li a")
    private List<WebElement> links;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public HomePage open() {
        driver.get("https://the-internet.herokuapp.com/");
        wait.until(ExpectedConditions.visibilityOfAllElements(links));
        return this;
    }

    public void clickLink(String text) {
        WebElement link = links.stream()
                .filter(el -> el.getText().contains(text))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Link not found: " + text));
        wait.until(ExpectedConditions.elementToBeClickable(link)).click();
    }
}