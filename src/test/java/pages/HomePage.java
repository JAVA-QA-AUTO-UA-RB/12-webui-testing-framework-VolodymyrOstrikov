package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;

    private final By abTestingLink = By.linkText("A/B Testing");
    private final By addRemoveElementsLink = By.linkText("Add/Remove Elements");
    private final By checkboxesLink = By.linkText("Checkboxes");
    private final By formAuthenticationLink = By.linkText("Form Authentication");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    public void goToAbTesting() {
        driver.findElement(abTestingLink).click();
    }

    public void goToAddRemoveElements() {
        driver.findElement(addRemoveElementsLink).click();
    }

    public void goToCheckboxes() {
        driver.findElement(checkboxesLink).click();
    }

    public void goToFormAuthentication() {
        driver.findElement(formAuthenticationLink).click();
    }
}
