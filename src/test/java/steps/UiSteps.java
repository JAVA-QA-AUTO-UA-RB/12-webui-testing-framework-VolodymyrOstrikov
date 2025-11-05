package steps;

import hooks.WebHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;

public class UiSteps {
    private HomePage home;
    private AbTestingPage ab;
    private AddRemoveElementsPage addRemove;
    private CheckboxesPage checkboxes;
    private LoginPage login;
    private SecureAreaPage secure;

    @Given("I open the home page")
    public void iOpenHomePage() {
        home = new HomePage(WebHooks.driver);
        home.open();
    }

    @When("I navigate to {string} page")
    public void iNavigateToPage(String page) {
        switch (page) {
            case "A/B Testing":
                home.goToAbTesting();
                ab = new AbTestingPage(WebHooks.driver);
                break;
            case "Add/Remove Elements":
                home.goToAddRemoveElements();
                addRemove = new AddRemoveElementsPage(WebHooks.driver);
                break;
            case "Checkboxes":
                home.goToCheckboxes();
                checkboxes = new CheckboxesPage(WebHooks.driver);
                break;
            case "Form Authentication":
                home.goToFormAuthentication();
                login = new LoginPage(WebHooks.driver);
                break;
        }
    }

    @Then("I should see text that contains {string}")
    public void iShouldSeeText(String expected) {
        Assert.assertTrue(ab.getHeaderText().contains(expected),
                "Очікуваний текст '" + expected + "' відсутній у заголовку");
    }

    @Then("the page URL should contain {string}")
    public void thePageUrlShouldContain(String urlPart) {
        Assert.assertTrue(WebHooks.driver.getCurrentUrl().contains(urlPart),
                "URL не містить '" + urlPart + "'");
    }

    @When("I add {int} elements")
    public void iAddElements(int count) {
        addRemove.addElements(count);
    }

    @Then("I should see {int} delete buttons")
    public void iShouldSeeDeleteButtons(int count) {
        Assert.assertEquals(addRemove.getDeleteButtonsCount(), count,
                "Кількість кнопок видалення не співпадає");
    }

    @When("I remove all elements")
    public void iRemoveAllElements() {
        addRemove.removeAll();
    }

    @When("I toggle the first checkbox")
    public void iToggleFirstCheckbox() {
        checkboxes.toggleCheckbox(0);
    }

    @Then("the first checkbox should be checked")
    public void theFirstCheckboxShouldBeChecked() {
        Assert.assertTrue(checkboxes.isChecked(0), "Перший чекбокс не позначено");
    }

    @When("I toggle the second checkbox")
    public void iToggleSecondCheckbox() {
        checkboxes.toggleCheckbox(1);
    }

    @Then("the second checkbox should not be checked")
    public void theSecondCheckboxShouldNotBeChecked() {
        Assert.assertFalse(checkboxes.isChecked(1), "Другий чекбокс позначено");
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        login.login(username, password);
        secure = new SecureAreaPage(WebHooks.driver);
    }

    @Then("I should see a success message containing {string}")
    public void iShouldSeeSuccessMessageContaining(String messagePart) {
        Assert.assertTrue(secure.getSuccessMessage().contains(messagePart),
                "Повідомлення не містить '" + messagePart + "'");
    }

    @Then("I should be able to logout")
    public void iShouldBeAbleToLogout() {
        secure.logout();
        Assert.assertTrue(WebHooks.driver.getCurrentUrl().contains("/login"),
                "Після виходу URL не повернувся до сторінки логіну");
    }

    @Then("I should see an error message containing {string}")
    public void iShouldSeeErrorMessageContaining(String messagePart) {
        Assert.assertTrue(login.getMessageText().contains(messagePart),
                "Помилка не містить '" + messagePart + "'");
    }
    @Then("the header should contain {string}")
    public void theHeaderShouldContain(String expectedText) {
        String actualHeader = ab.getHeaderText();
        Assert.assertTrue(actualHeader.contains(expectedText),
                "Заголовок не містить '" + expectedText + "'. Фактичний: '" + actualHeader + "'");
    }
}
