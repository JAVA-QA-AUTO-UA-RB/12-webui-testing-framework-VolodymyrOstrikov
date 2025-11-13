package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By abTestingLink = By.linkText("A/B Testing");
    private final By addRemoveElementsLink = By.linkText("Add/Remove Elements");
    private final By checkboxesLink = By.linkText("Checkboxes");
    private final By formAuthenticationLink = By.linkText("Form Authentication");
    private final By dropdownLink = By.linkText("Dropdown");
    private final By dragAndDropLink = By.linkText("Drag and Drop");
    private final By horizontalSliderLink = By.linkText("Horizontal Slider");


    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

    }

    public HomePage open() {
        driver.get("https://the-internet.herokuapp.com/");
        return this;
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

    public void goToDropdown() {
        driver.findElement(dropdownLink).click();
    }

    public void goToDragAndDrop() {
        driver.findElement(dragAndDropLink).click();
    }

    public void goToHorizontalSlider() {
        driver.findElement(horizontalSliderLink).click();
    }
    public LoginPage goToLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(formAuthenticationLink)).click();
        return new LoginPage(driver, wait);
    }
}