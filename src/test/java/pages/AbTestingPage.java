package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbTestingPage {
    private final WebDriver driver;
    private final By header = By.tagName("h3");

    public AbTestingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

}