package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AuthenticationTest extends BaseTest {
    @Test
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(driver, wait).open();
        SecureAreaPage securePage = loginPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(securePage.getSuccessMessage().contains("You logged into a secure area!"),
                "There is no message about successful login.");
        securePage.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL did not return to the login page");
    }

    @Test
    public void invalidLogin() {
        LoginPage loginPage = new LoginPage(driver, wait).open();
        loginPage.login("wrong", "wrong");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Your username is invalid!"),
                "There is no login error message.");
    }
}