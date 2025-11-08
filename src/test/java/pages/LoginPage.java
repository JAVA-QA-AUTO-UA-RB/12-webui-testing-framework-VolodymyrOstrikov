package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement message;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        driver.get("https://the-internet.herokuapp.com/login");
        return this;
    }

    public SecureAreaPage login(String user, String pass) {
        if (user == null || pass == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
        return new SecureAreaPage(driver, wait);
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getText();
    }
}