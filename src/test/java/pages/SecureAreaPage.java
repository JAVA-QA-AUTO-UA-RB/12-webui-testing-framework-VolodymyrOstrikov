package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecureAreaPage {
    @SuppressWarnings("unused")
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "flash")
    private WebElement message;

    @FindBy(css = ".button[href='/logout']")
    private WebElement logoutButton;

    public SecureAreaPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getText().trim();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}