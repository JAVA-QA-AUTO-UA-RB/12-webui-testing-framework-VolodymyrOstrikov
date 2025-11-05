package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage {
    private final WebDriver driver;

    @FindBy(css = "#checkboxes input")
    private List<WebElement> checkboxes;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void toggleCheckbox(int index) {
        checkboxes.get(index).click();
    }

    public boolean isChecked(int index) {
        return checkboxes.get(index).isSelected();
    }
}
