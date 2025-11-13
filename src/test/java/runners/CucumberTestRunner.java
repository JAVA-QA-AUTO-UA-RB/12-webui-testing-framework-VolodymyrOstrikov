package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.picocontainer.PicoFactory;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"},
        tags = "@ui",
        monochrome = true,
        objectFactory = PicoFactory.class
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}