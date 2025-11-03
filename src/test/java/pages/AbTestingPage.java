package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbTestingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#content h3")
    private WebElement header;

    public AbTestingPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public AbTestingPage open() {
        driver.get("https://the-internet.herokuapp.com/abtest");
        return this;
    }

    public String getHeaderText() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.getText();
    }
}