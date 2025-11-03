package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class AuthenticationTest extends BaseTest {

    @Test
    public void successfulLogin() {
        new HomePage(driver, wait).open().clickLink("Form Authentication");
        LoginPage login = new LoginPage(driver, wait);
        var secure = login.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(secure.getSuccessMessage().contains("You logged into a secure area!"));
        secure.logout();
    }

    @Test
    public void invalidLogin() {
        new HomePage(driver, wait).open().clickLink("Form Authentication");
        LoginPage login = new LoginPage(driver, wait);
        login.login("wrong", "wrong");
        Assert.assertTrue(login.getErrorMessage().contains("Your username is invalid!"));
    }
}