
package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebHooks {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp(Scenario scenario) {
        try {
            // Ініціалізація WebDriver
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
            System.out.println("Test started: " + scenario.getName());
        } catch (Exception e) {
            System.err.println("Failed to set up WebDriver: " + e.getMessage());
            throw new RuntimeException("WebDriver initialization failed", e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            try {
                if (scenario.isFailed()) {
                    System.out.println("Test failed: " + scenario.getName());
                } else {
                    System.out.println("Test passed: " + scenario.getName());
                }
                driver.quit();
            } catch (Exception e) {
                System.err.println("Failed to tear down WebDriver: " + e.getMessage());
            } finally {
                driver = null;
                wait = null;
            }
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized");
        }
        return driver;
    }

    public WebDriverWait getWait() {
        if (wait == null) {
            throw new IllegalStateException("WebDriverWait is not initialized");
        }
        return wait;
    }
}