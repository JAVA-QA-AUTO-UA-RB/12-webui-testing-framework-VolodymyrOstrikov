import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;




public class SeleniumTestngTest extends BasicSetupTest {
    private static final String TEST_URL = "https://the-internet.herokuapp.com/";

    @Test
    public void abTestingPageHasSpecificTextTest()  {

        browser.get(TEST_URL);

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement abTestingTaskLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'A/B Testing')]")));
        abTestingTaskLink.click();

        WebElement resultElement = browser.findElement(By.xpath("//*[contains(text(), 'A/B Test')]"));
        Assert.assertTrue(resultElement.isDisplayed(), "Expected A/B Test content not found");
    }


    @Test
    public void addRemoveElementsTest() throws InterruptedException {

        browser.get(TEST_URL + "add_remove_elements/");
        WebElement addButton = browser.findElement(By.cssSelector("button[onclick='addElement()']"));


        for (int i = 0; i < 3; i++) {
            addButton.click();
        }


        int deleteButtonsCount = browser.findElements(By.cssSelector(".added-manually")).size();
        Assert.assertEquals(deleteButtonsCount, 3, "Expected 3 Delete buttons to be added");


        for (WebElement deleteButton : browser.findElements(By.cssSelector(".added-manually"))) {
            deleteButton.click();
        }


        deleteButtonsCount = browser.findElements(By.cssSelector(".added-manually")).size();
        Assert.assertEquals(deleteButtonsCount, 0, "Delete buttons were not removed");
    }

    @Test
    public void checkboxesTest() throws InterruptedException {

        browser.get(TEST_URL + "checkboxes");
        WebElement checkbox1 = browser.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
        WebElement checkbox2 = browser.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }


        Assert.assertTrue(checkbox1.isSelected(), "Checkbox 1 is not selected");
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 is not selected");
    }

    @Test
    public void dropdownTest() throws InterruptedException {

        browser.get(TEST_URL + "dropdown");
        WebElement dropdownElement = browser.findElement(By.cssSelector("#dropdown"));
        Select dropdown = new Select(dropdownElement);


        dropdown.selectByVisibleText("Option 2");


        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2", "Option 2 is not selected");
    }

    @Test
    public void formAuthenticationTest() throws InterruptedException {

        browser.get(TEST_URL + "login");
        WebElement usernameField = browser.findElement(By.cssSelector("input#username"));
        WebElement passwordField = browser.findElement(By.cssSelector("input#password"));
        WebElement loginButton = browser.findElement(By.cssSelector("button[type='submit']"));


        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");
        loginButton.click();


        WebElement successMessage = browser.findElement(By.cssSelector(".flash.success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Login was not successful");


        WebElement logoutButton = browser.findElement(By.cssSelector("a[href='/logout']"));
        logoutButton.click();


        WebElement logoutMessage = browser.findElement(By.cssSelector(".flash.success"));
        Assert.assertTrue(logoutMessage.isDisplayed(), "Logout was not successful");
        Assert.assertTrue(logoutMessage.getText().contains("You logged out of the secure area!"),
                "Unexpected logout message");
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {

        browser.get(TEST_URL + "drag_and_drop");
        WebElement elementA = browser.findElement(By.cssSelector("#column-a"));
        WebElement elementB = browser.findElement(By.cssSelector("#column-b"));


        Actions actions = new Actions(browser);
        actions.dragAndDrop(elementA, elementB).perform();


        String headerA = browser.findElement(By.cssSelector("#column-a header")).getText();
        Assert.assertEquals(headerA, "B", "Element A was not dragged to position B");
    }

    @Test
    public void horizontalSliderTest() {
        browser.get(TEST_URL + "horizontal_slider");

        WebElement slider = browser.findElement(By.cssSelector("input[type='range']"));
        WebElement valueDisplay = browser.findElement(By.id("range"));

        String target = "0.5";

        while (!valueDisplay.getText().equals(target)) {
            if (Double.parseDouble(valueDisplay.getText()) < Double.parseDouble(target)) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            } else {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
        }

        Assert.assertEquals(valueDisplay.getText(), target,
                "Slider did not move to the expected value " + target);
    }
}