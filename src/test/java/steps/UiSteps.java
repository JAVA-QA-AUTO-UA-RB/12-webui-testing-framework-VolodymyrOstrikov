package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;

public class UiSteps {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private HomePage home;
    private AbTestingPage ab;
    private AddRemoveElementsPage addRemove;
    private CheckboxesPage checkboxes;
    private LoginPage login;
    private SecureAreaPage secure;

    public UiSteps(WebHooks webHooks) {
        this.driver = webHooks.getDriver();
        this.wait = webHooks.getWait();
        if (driver == null || wait == null) {
            throw new IllegalStateException("WebDriver or WebDriverWait initialization failed.");
        }
    }

    @Given("I open the home page")
    public void iOpenHomePage() {
        home = new HomePage(driver, wait).open();
    }

    @When("I navigate to {string} page")
    public void iNavigateToPage(String pageName) {
        switch (pageName) {
            case "A/B Testing":
                home.goToAbTesting();
                ab = new AbTestingPage(driver, wait);
                break;
            case "Add/Remove Elements":
                home.goToAddRemoveElements();
                addRemove = new AddRemoveElementsPage(driver, wait);
                break;
            case "Checkboxes":
                home.goToCheckboxes();
                checkboxes = new CheckboxesPage(driver, wait);
                break;
            case "Form Authentication":
                login = home.goToLogin();
                break;
            default:
                throw new IllegalArgumentException("Unknown page: " + pageName);
        }
    }

    @Then("the page URL should contain {string}")
    public void thePageUrlShouldContain(String urlPart) {
        Assert.assertTrue(driver.getCurrentUrl().contains(urlPart), "URL не містить '" + urlPart + "'");
    }

    @When("I add {int} elements")
    public void iAddElements(int count) {
        addRemove = new AddRemoveElementsPage(driver, wait).open();
        for (int i = 0; i < count; i++) {
            addRemove.clickAdd();
        }
    }

    @Then("I should see {int} delete buttons")
    public void iShouldSeeDeleteButtons(int count) {
        Assert.assertEquals(addRemove.getDeleteButtonsCount(), count, "The number of delete buttons does not match");
    }

    @When("I remove all elements")
    public void iRemoveAllElements() {
        addRemove.deleteAll();
    }

    @When("I toggle the first checkbox")
    public void iToggleFirstCheckbox() {
        checkboxes.toggleCheckbox(0);
    }

    @Then("the first checkbox should be checked")
    public void theFirstCheckboxShouldBeChecked() {
        Assert.assertTrue(checkboxes.isChecked(0), "The first checkbox is not checked.");
    }

    @When("I toggle the second checkbox")
    public void iToggleSecondCheckbox() {
        checkboxes.toggleCheckbox(1);
    }

    @Then("the second checkbox should not be checked")
    public void theSecondCheckboxShouldNotBeChecked() {
        Assert.assertFalse(checkboxes.isChecked(1), "The second checkbox is checked.");
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        secure = login.login(username, password);
    }

    @Then("I should see a success message containing {string}")
    public void iShouldSeeSuccessMessageContaining(String messagePart) {
        Assert.assertTrue(secure.getSuccessMessage().contains(messagePart), "The message does not contain '" + messagePart + "'");
    }

    @Then("I should be able to logout")
    public void iShouldBeAbleToLogout() {
        secure.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "After logging out, the URL did not return to the login page");
    }

    @Then("I should see an error message containing {string}")
    public void iShouldSeeErrorMessageContaining(String messagePart) {
        Assert.assertTrue(login.getErrorMessage().contains(messagePart), "The error does not contain '" + messagePart + "'");
    }

    @Then("the header should contain {string}")
    public void theHeaderShouldContain(String expectedText) {
        String headerText = ab.getHeaderText();
        Assert.assertTrue(headerText.contains(expectedText) || headerText.contains("A/B Test Control"),
                "Header does not contain expected text: " + expectedText + ", actual: " + headerText);
    }
}