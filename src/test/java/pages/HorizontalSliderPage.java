package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HorizontalSliderPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement value;

    public HorizontalSliderPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public HorizontalSliderPage open() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        return this;
    }

    public void moveSliderTo(String targetValue) {
        wait.until(ExpectedConditions.visibilityOf(slider));
        while (!value.getText().equals(targetValue)) {
            if (Double.parseDouble(value.getText()) < Double.parseDouble(targetValue)) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            } else {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
        }
    }

    public String getValue() {
        return value.getText();
    }
}