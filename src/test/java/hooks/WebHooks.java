package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


    public class WebHooks {
        public static WebDriver driver;

        @Before
        public void setUp() {
            // TODO: зчитування опцій із системних властивостей (headless, window size тощо)
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @After
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
}
